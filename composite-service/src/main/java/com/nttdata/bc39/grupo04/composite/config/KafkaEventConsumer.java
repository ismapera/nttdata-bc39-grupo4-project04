package com.nttdata.bc39.grupo04.composite.config;

import com.nttdata.bc39.grupo04.api.kafka.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaEventConsumer {

    Logger logger = LoggerFactory.getLogger(KafkaEventConsumer.class);

    @KafkaListener(topics = KafkaEventConfig.TOPIC_EVENT, groupId = "group_id")
    public void consume(Event<?> event) {
        logger.info("Consuming Message {}", event.getMessage());
    }

}