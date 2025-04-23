package ru.mkhamkha.paymentservice.psa.service.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mkhamkha.paymentservice.psa.model.dto.CreatePaymentTransactionRequest;
import ru.mkhamkha.paymentservice.psa.model.entity.BankAccount;
import ru.mkhamkha.paymentservice.psa.model.mapper.PaymentTransactionMapper;
import ru.mkhamkha.paymentservice.psa.service.BankAccountService;
import ru.mkhamkha.paymentservice.psa.service.PaymentTransactionService;
import ru.mkhamkha.paymentservice.psa.service.PaymentTransactionValidator;
import ru.mkhamkha.paymentservice.psa.util.JsonConverter;
import ru.mkhamkha.paymentservice.psa.util.enums.PaymentTransactionStatus;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreatePaymentTransactionHandler implements PaymentTransactionCommandHandler {

    private final JsonConverter converter;
    private final PaymentTransactionValidator paymentTransactionValidator;
    private final BankAccountService bankAccountService;
    private final PaymentTransactionMapper paymentTransactionMapper;
    private final PaymentTransactionService paymentTransactionService;

    @Override
    @Transactional
    public void process(String requestId, String message) {
        var request = converter.fromJson(message, CreatePaymentTransactionRequest.class);
        paymentTransactionValidator.validateCreatePaymentTransaction(request);

        var sourcesBankAccount = bankAccountService.findById(request.getSourcesBankAccountId()).get();

        sourcesBankAccount.setBalance(
                sourcesBankAccount.getBalance().subtract(request.getAmount())
        );
        Optional<BankAccount> destinationBankAccount = Optional.empty();
        if (request.getDestinationBankAccountId() != null) {
            destinationBankAccount = bankAccountService.findById(request.getDestinationBankAccountId());
            destinationBankAccount.get().setBalance(
                    sourcesBankAccount.getBalance().add(request.getAmount())
            );
        }

        var entity = paymentTransactionMapper.toEntity(request);
        entity.setDestinationBankAccount(sourcesBankAccount);
        destinationBankAccount.ifPresent(entity::setDestinationBankAccount);
        entity.setPaymentTransactionStatus(PaymentTransactionStatus.SUCCESS);

        var savedEntity = paymentTransactionService.save(entity);
    }
}
