package com.pefonseca.account.service.domain.dto.request;

import com.pefonseca.account.service.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDomainDTO {

    private String name;
    private String cpf;
    private String email;
    private String phone;
    private LocalDateTime birthDate;

    public User toEntity() {
        return User.builder()
                   .name(this.name)
                   .cpf(this.cpf)
                   .email(this.email)
                   .phone(this.phone)
                   .birthDate(this.birthDate)
                   .createdAt(Instant.now())
                   .build();
    }

}
