package ru.mkhamkha.paymentservice.psa.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mkhamkha.paymentservice.psa.model.entity.PaymentTransaction;
import ru.mkhamkha.paymentservice.psa.repository.PaymentTransactionRepository;


@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentTransactionService {

    private final PaymentTransactionRepository repository;

    @Transactional
    public PaymentTransaction save(PaymentTransaction paymentTransaction) {
        return repository.save(paymentTransaction);
    }
}
