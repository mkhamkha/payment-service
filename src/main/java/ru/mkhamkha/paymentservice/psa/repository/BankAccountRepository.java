package ru.mkhamkha.paymentservice.psa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mkhamkha.paymentservice.psa.model.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
