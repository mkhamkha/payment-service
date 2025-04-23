package ru.mkhamkha.paymentservice.psa.model.mapper;

import org.mapstruct.Mapper;
import ru.mkhamkha.paymentservice.psa.model.dto.CreatePaymentTransactionRequest;
import ru.mkhamkha.paymentservice.psa.model.entity.PaymentTransaction;

@Mapper(componentModel = "spring")
public interface PaymentTransactionMapper {

    PaymentTransaction toEntity(CreatePaymentTransactionRequest request);
    CreatePaymentTransactionRequest toResponse(PaymentTransaction paymentTransaction);
}
