package ru.mkhamkha.paymentservice.psa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mkhamkha.paymentservice.psa.model.entity.PaymentTransaction;

public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, Long> {
}
