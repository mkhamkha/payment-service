package ru.mkhamkha.paymentservice.psa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mkhamkha.paymentservice.psa.model.entity.Refund;

public interface RefundRepository extends JpaRepository<Refund, Long> {
}

