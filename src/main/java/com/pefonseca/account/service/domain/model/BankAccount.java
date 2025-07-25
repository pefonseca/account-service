package com.pefonseca.account.service.domain.model;

import com.pefonseca.account.service.domain.dto.response.BankAccountResponseDomainDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity(name = "tb_bank_account")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    private BigDecimal balance;

    private String agencyNumber;
    private String accountNumber;

    private Instant createdAt;

    @Version
    private Long version;

    public BankAccountResponseDomainDTO toDTO() {
        return BankAccountResponseDomainDTO.builder()
                                           .id(this.id)
                                           .owner(this.owner)
                                           .balance(this.balance)
                                           .agencyNumber(this.agencyNumber)
                                           .accountNumber(this.accountNumber)
                                           .createdAt(this.createdAt)
                                           .build();
    }

}
