package ru.mkhamkha.paymentservice.psa.util.enums;

import lombok.Getter;

@Getter
public enum CommandResultStatus {
    SUCCESS,
    FAILED;

    public static CommandResultStatus fromString(String status) {
        for (CommandResultStatus value : CommandResultStatus.values()) {
            if (value.toString().equals(status)) {
                return value;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid CommandResultStatus %s", status));
    }
}
