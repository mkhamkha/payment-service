package ru.mkhamkha.paymentservice.psa.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentTransactionRequest {

    @NotNull
    private Long sourcesBankAccountId;

    private Long destinationBankAccountId;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private String currency;

    private String description;
}
