package ru.mkhamkha.paymentservice.psa.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mkhamkha.paymentservice.psa.exceptions.PaymentTransactionValidationException;
import ru.mkhamkha.paymentservice.psa.model.dto.CreatePaymentTransactionRequest;
import ru.mkhamkha.paymentservice.psa.model.entity.BankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentTransactionValidator {

    private final Validator validator;
    private final BankAccountService bankAccountService;

    public void validateCreatePaymentTransaction(CreatePaymentTransactionRequest request) {

        var violations = validator.validate(request);
        List<String> errors = new ArrayList<>(
                violations.stream()
                        .map(ConstraintViolation::getMessage)
                        .toList()
        );
        Optional<BankAccount> sourceBank = Optional.empty();
        if (request.getSourcesBankAccountId() != null) {
            sourceBank = bankAccountService.findById(request.getSourcesBankAccountId());
            if (sourceBank.isEmpty()) errors.add("Source bank account not found id:" + request.getSourcesBankAccountId());
        }

        if (request.getDestinationBankAccountId() != null) {
            var destinationBank = bankAccountService.findById(request.getSourcesBankAccountId());
            if (destinationBank.isEmpty()) errors.add("Destination bank account not found id:" + request.getDestinationBankAccountId());
        }

        if (request.getAmount() != null && sourceBank.isPresent()) {
            if (sourceBank.get().getBalance().compareTo(request.getAmount()) < 0) {
                errors.add("Source bank account balance less then request amount, sources account id:" + request.getSourcesBankAccountId());
            }
        }

        if (!errors.isEmpty()) {
            throw new PaymentTransactionValidationException(errors);
        }
    }
}
