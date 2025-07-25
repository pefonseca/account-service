package com.pefonseca.account.service.domain.service;

import com.pefonseca.account.service.domain.dto.request.BankAccountRequestDomainDTO;
import com.pefonseca.account.service.domain.dto.response.BankAccountResponseDomainDTO;

public interface BankAccountService {

    BankAccountResponseDomainDTO create(BankAccountRequestDomainDTO bankAccountRequestDomainDTO);

}
