package ru.mkhamkha.paymentservice.psa.util.enums;

import lombok.Getter;

@Getter
public enum RefundStatus {

    COMPLETED,
    FAILED;

    public static RefundStatus fromString(String status) {
        for (RefundStatus value : RefundStatus.values()) {
            if (value.toString().equals(status)) {
                return value;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid RefundStatus %s", status));
    }
}
