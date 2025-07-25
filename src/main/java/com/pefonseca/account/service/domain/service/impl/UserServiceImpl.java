package com.pefonseca.account.service.domain.service.impl;

import com.pefonseca.account.service.domain.dto.request.UserRequestDomainDTO;
import com.pefonseca.account.service.domain.dto.response.UserResponseDomainDTO;
import com.pefonseca.account.service.domain.service.UserService;
import com.pefonseca.account.service.infra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public UserResponseDomainDTO findById(UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new RuntimeException("User not found."))
                         .toDTO();
    }

    @Override
    public UserResponseDomainDTO create(UserRequestDomainDTO userRequestDomainDTO) {
        return repository.save(userRequestDomainDTO.toEntity())
                         .toDTO();
    }

}
