package com.pefonseca.account.service.domain.service.impl;

import com.pefonseca.account.service.domain.dto.request.BankAccountRequestDomainDTO;
import com.pefonseca.account.service.domain.dto.response.BankAccountResponseDomainDTO;
import com.pefonseca.account.service.domain.service.BankAccountService;
import com.pefonseca.account.service.infra.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository repository;

    @Override
    public BankAccountResponseDomainDTO create(BankAccountRequestDomainDTO bankAccountRequestDomainDTO) {
        return repository.save(bankAccountRequestDomainDTO.toEntity()).toDTO();
    }

}
