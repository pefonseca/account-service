package com.pefonseca.account.service.domain.dto.general;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountCreatedEventDTO {
    private UUID userId;
    private String name;
    private String email;
    private String phone;
    private String cpf;
    private LocalDateTime birthDate;

    private UUID accountId;
    private String agencyNumber;
    private String accountNumber;
    private BigDecimal balance;
    private Instant createdAt;
}