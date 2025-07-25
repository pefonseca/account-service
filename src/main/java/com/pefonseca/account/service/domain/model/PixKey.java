package com.pefonseca.account.service.domain.model;

import com.pefonseca.account.service.domain.model.enums.PixKeyType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity(name = "tb_pix_key")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PixKey {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private BankAccount account;

    @Enumerated(EnumType.STRING)
    private PixKeyType type;

    private String value;

    private Instant createdAt;

    private boolean active;

}
