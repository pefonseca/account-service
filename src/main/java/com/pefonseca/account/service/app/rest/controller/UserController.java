package com.pefonseca.account.service.app.rest.controller;

import com.pefonseca.account.service.domain.dto.request.UserRequestDomainDTO;
import com.pefonseca.account.service.domain.dto.response.UserResponseDomainDTO;
import com.pefonseca.account.service.domain.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDomainDTO> findById(@PathVariable(value = "id") UUID id) {
        var result = userService.findById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<UserResponseDomainDTO> create(@Valid @RequestBody UserRequestDomainDTO requestDomainDTO) {
        var result = userService.create(requestDomainDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

}
