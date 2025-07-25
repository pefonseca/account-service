package com.pefonseca.account.service.domain.dto.request;

import com.pefonseca.account.service.domain.model.BankAccount;
import com.pefonseca.account.service.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountRequestDomainDTO {

    private User owner;
    private BigDecimal balance;
    private String agencyNumber;
    private String accountNumber;
    private Instant createdAt;

    public BankAccount toEntity() {
        return BankAccount.builder()
                          .owner(this.owner)
                          .balance(this.balance)
                          .agencyNumber(this.agencyNumber)
                          .accountNumber(this.accountNumber)
                          .createdAt(this.createdAt)
                          .build();
    }
}
