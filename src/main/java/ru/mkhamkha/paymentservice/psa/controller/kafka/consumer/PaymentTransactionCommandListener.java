package ru.mkhamkha.paymentservice.psa.controller.kafka.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.mkhamkha.paymentservice.psa.util.enums.PaymentTransactionCommand;
import ru.mkhamkha.paymentservice.psa.service.handler.PaymentTransactionCommandHandler;

import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentTransactionCommandListener {

    private final Map<PaymentTransactionCommand, PaymentTransactionCommandHandler> commandHandlers;

    @KafkaListener(topics = "payment-command", containerFactory = "kafkaListenerContainerFactory")
    public void consumerPaymentTransactionCommand(ConsumerRecord<String, String> record) {
        var command = getPaymentTransactionCommand(record);
        var commandHandler = commandHandlers.get(command);

        if (commandHandler == null) {
            throw new IllegalArgumentException(String.format("Unknown command: %s, record %s", command, record));
        }

        commandHandler.process(record.key(), record.value());
    }

    private PaymentTransactionCommand getPaymentTransactionCommand(ConsumerRecord<String, String> record) {
        var commandHeader = record.headers().lastHeader("command");
        if (commandHeader != null) {
            return PaymentTransactionCommand.fromString(new String(commandHeader.value()));
        }
        // Если заголовок не передан
        return PaymentTransactionCommand.UNKNOWN;
    }
}
