package com.pefonseca.account.service.domain.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pefonseca.account.service.domain.dto.general.UserAccountCreatedEventDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserAccountEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value("${spring.kafka.topics.user-account-created}")
    private String accountCreatedTopic;

    public void sendUserAccountCreated(UserAccountCreatedEventDTO event) {
        try {
            String payload = objectMapper.writeValueAsString(event);  // usa o ObjectMapper injetado
            kafkaTemplate.send(accountCreatedTopic, payload);
            log.info("Mensagem enviada ao tópico {}: {}", accountCreatedTopic, payload);
        } catch (JsonProcessingException e) {
            log.error("Erro ao serializar evento", e);
        }
    }

}