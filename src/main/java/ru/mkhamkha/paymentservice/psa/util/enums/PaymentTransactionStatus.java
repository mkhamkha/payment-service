package ru.mkhamkha.paymentservice.psa.util.enums;

import lombok.Getter;

@Getter
public enum PaymentTransactionStatus {

    PROCESSING,
    SUCCESS,
    FAILED;

    public static PaymentTransactionStatus fromString(String status) {
        for (PaymentTransactionStatus value : PaymentTransactionStatus.values()) {
            if (value.toString().equals(status)) {
                return value;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid PaymentTransactionStatus %s", status));
    }
}
