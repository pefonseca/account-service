package com.pefonseca.account.service.domain.service.impl;

import com.pefonseca.account.service.domain.dto.general.UserAccountCreatedEventDTO;
import com.pefonseca.account.service.domain.dto.request.BankAccountRequestDomainDTO;
import com.pefonseca.account.service.domain.dto.request.UserRequestDomainDTO;
import com.pefonseca.account.service.domain.dto.response.UserResponseDomainDTO;
import com.pefonseca.account.service.domain.model.BankAccount;
import com.pefonseca.account.service.domain.producer.UserAccountEventProducer;
import com.pefonseca.account.service.domain.service.BankAccountService;
import com.pefonseca.account.service.domain.service.UserService;
import com.pefonseca.account.service.infra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final BankAccountService accountService;
    private final UserAccountEventProducer producer;

    @Override
    public UserResponseDomainDTO findById(UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new RuntimeException("User not found."))
                         .toDTO();
    }

    @Override
    public UserResponseDomainDTO create(UserRequestDomainDTO userRequestDomainDTO) {

        var user = repository.save(userRequestDomainDTO.toEntity()).toDTO();

        BankAccountRequestDomainDTO account = BankAccountRequestDomainDTO.builder()
                                                                         .owner(user.toEntity())
                                                                         .balance(BigDecimal.ZERO)
                                                                         .agencyNumber(generateAgency())
                                                                         .accountNumber(generateAccountNumber())
                                                                         .createdAt(Instant.now())
                                                                         .build();

        var bankAccount = accountService.create(account);

        var userEvent = UserAccountCreatedEventDTO.builder()
                .userId(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .cpf(user.getCpf())
                .birthDate(user.getBirthDate())
                .accountId(bankAccount.getId())
                .agencyNumber(bankAccount.getAgencyNumber())
                .accountNumber(bankAccount.getAccountNumber())
                .balance(bankAccount.getBalance())
                .createdAt(bankAccount.getCreatedAt())
                .build();

        producer.sendUserAccountCreated(userEvent);

        return user;
    }

    private String generateAgency() {
        return "0001";
    }

    private String generateAccountNumber() {
        return String.valueOf(ThreadLocalRandom.current().nextInt(100000, 999999));
    }

}
