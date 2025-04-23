package ru.mkhamkha.paymentservice.psa.util.enums;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum PaymentTransactionCommand {

    CREATE,
    REFUND,
    UNKNOWN;

    public static PaymentTransactionCommand fromString(String command) {
        try {
            return PaymentTransactionCommand.valueOf(command);
        } catch (IllegalArgumentException e) {
            log.error("Неизвестная команда. Message {}", e.getMessage());
            return UNKNOWN;
        }
    }
}
