package com.pefonseca.account.service.domain.producer;

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

    private final KafkaTemplate<String, UserAccountCreatedEventDTO> kafkaTemplate;

    @Value("${kafka.topics.user-account-create}")
    private String accountCreatedTopic;

    public void publishUserAccountCreated(UserAccountCreatedEventDTO eventDTO) {
        kafkaTemplate.send(accountCreatedTopic, eventDTO);
        log.info("[UserAccountEventProducer] - (publishUserAccountCreated): event published: {}", eventDTO);
    }

}
