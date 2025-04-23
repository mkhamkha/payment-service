package ru.mkhamkha.paymentservice.psa.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mkhamkha.paymentservice.psa.model.entity.BankAccount;
import ru.mkhamkha.paymentservice.psa.repository.BankAccountRepository;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BankAccountService {

    private final BankAccountRepository repository;

    @Transactional
    public Optional<BankAccount> findById(Long id) {
        return repository.findById(id);
    }
}
