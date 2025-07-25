package com.pefonseca.account.service.domain.service;

import com.pefonseca.account.service.domain.dto.request.UserRequestDomainDTO;
import com.pefonseca.account.service.domain.dto.response.UserResponseDomainDTO;

import java.util.UUID;

public interface UserService {

    UserResponseDomainDTO findById(UUID id);
    UserResponseDomainDTO create(UserRequestDomainDTO userRequestDomainDTO);

}
