package com.pefonseca.account.service.domain.model;

import com.pefonseca.account.service.domain.dto.response.UserResponseDomainDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "tb_user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String cpf;
    private String email;
    private String phone;

    private LocalDateTime birthDate;

    private Instant createdAt;

    @OneToMany(mappedBy = "owner")
    private List<BankAccount> accounts;

    public UserResponseDomainDTO toDTO() {
        return UserResponseDomainDTO.builder()
                                    .id(this.id)
                                    .name(this.name)
                                    .cpf(this.cpf)
                                    .email(this.email)
                                    .phone(this.phone)
                                    .birthDate(this.birthDate)
                                    .createdAt(this.createdAt)
                                    .build();
    }
}
