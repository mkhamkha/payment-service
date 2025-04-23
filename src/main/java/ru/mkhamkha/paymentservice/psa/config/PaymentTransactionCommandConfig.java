package ru.mkhamkha.paymentservice.psa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mkhamkha.paymentservice.psa.util.enums.PaymentTransactionCommand;
import ru.mkhamkha.paymentservice.psa.service.handler.CancelPaymentTransactionHandler;
import ru.mkhamkha.paymentservice.psa.service.handler.CreatePaymentTransactionHandler;
import ru.mkhamkha.paymentservice.psa.service.handler.PaymentTransactionCommandHandler;

import java.util.Map;

@Configuration
public class PaymentTransactionCommandConfig {

    @Bean
    public Map<PaymentTransactionCommand, PaymentTransactionCommandHandler> commandHandlers(
            CreatePaymentTransactionHandler createPaymentTransactionHandler,
            CancelPaymentTransactionHandler cancelPaymentTransactionHandler
    ) {
        return Map.of(
                PaymentTransactionCommand.CREATE, createPaymentTransactionHandler,
                PaymentTransactionCommand.REFUND, cancelPaymentTransactionHandler
        );
    }
}
