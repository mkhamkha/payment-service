package ru.mkhamkha.paymentservice.psa.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PaymentTransactionValidationException extends RuntimeException {
    private List<String> errors;
}
