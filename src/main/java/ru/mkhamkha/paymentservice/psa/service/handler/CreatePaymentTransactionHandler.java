package ru.mkhamkha.paymentservice.psa.service.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mkhamkha.paymentservice.psa.model.dto.CreatePaymentTransactionRequest;
import ru.mkhamkha.paymentservice.psa.service.PaymentTransactionValidator;
import ru.mkhamkha.paymentservice.psa.util.JsonConverter;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreatePaymentTransactionHandler implements PaymentTransactionCommandHandler {

    private final JsonConverter converter;
    private final PaymentTransactionValidator paymentTransactionValidator;

    @Override
    public void process(String requestId, String message) {
        var request = converter.fromJson(message, CreatePaymentTransactionRequest.class);
        paymentTransactionValidator.validateCreatePaymentTransaction(request);


    }
}
