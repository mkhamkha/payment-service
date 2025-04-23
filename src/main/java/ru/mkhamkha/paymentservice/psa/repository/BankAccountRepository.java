package ru.mkhamkha.paymentservice.psa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mkhamkha.paymentservice.psa.model.entity.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
