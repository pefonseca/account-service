package com.pefonseca.account.service.domain.dto.response;

import com.pefonseca.account.service.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountResponseDomainDTO {

    private UUID id;
    private User owner;
    private BigDecimal balance;
    private String agencyNumber;
    private String accountNumber;
    private Instant createdAt;

}
