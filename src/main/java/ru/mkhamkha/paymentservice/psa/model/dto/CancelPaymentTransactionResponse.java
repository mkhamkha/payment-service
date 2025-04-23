package ru.mkhamkha.paymentservice.psa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mkhamkha.paymentservice.psa.util.enums.CommandResultStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CancelPaymentTransactionResponse {

    private Long refundId;

    private CommandResultStatus status;

    private String errorMessage;
}
