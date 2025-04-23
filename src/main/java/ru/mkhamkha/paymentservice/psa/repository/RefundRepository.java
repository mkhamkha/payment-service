package ru.mkhamkha.paymentservice.psa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mkhamkha.paymentservice.psa.model.entity.Refund;

@Repository
public interface RefundRepository extends JpaRepository<Refund, Long> {
}

