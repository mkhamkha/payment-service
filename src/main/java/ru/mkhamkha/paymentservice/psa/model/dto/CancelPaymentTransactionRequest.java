package ru.mkhamkha.paymentservice.psa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CancelPaymentTransactionRequest {

    @NotNull
    private Long transactionId;

    @NotNull
    @Min(value = 1, message = "Сумма возврата должна быть больше 0")
    private BigDecimal refundedAmount;

    private String reason;


}
