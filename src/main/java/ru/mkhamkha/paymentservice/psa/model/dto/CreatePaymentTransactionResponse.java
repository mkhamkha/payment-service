package ru.mkhamkha.paymentservice.psa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mkhamkha.paymentservice.psa.util.enums.CommandResultStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentTransactionResponse {

    private Long paymentTransactionId;

    private CommandResultStatus status;

    private String errorMessage;

    private LocalDateTime executedAt;
}
