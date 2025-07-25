package com.pefonseca.account.service.domain.dto.response;

import com.pefonseca.account.service.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDomainDTO {

    private UUID id;
    private String name;
    private String cpf;
    private String email;
    private String phone;
    private LocalDateTime birthDate;
    private Instant createdAt;

    public User toEntity() {
        return User.builder()
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
