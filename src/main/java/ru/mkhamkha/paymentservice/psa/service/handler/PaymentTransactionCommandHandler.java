package ru.mkhamkha.paymentservice.psa.service.handler;

public interface PaymentTransactionCommandHandler {
    void process(String requestId, String message);
}
