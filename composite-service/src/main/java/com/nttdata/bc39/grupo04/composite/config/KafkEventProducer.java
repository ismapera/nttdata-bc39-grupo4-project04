package com.nttdata.bc39.grupo04.composite.config;

import com.nttdata.bc39.grupo04.api.kafka.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkEventProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkEventProducer.class);

    private final KafkaTemplate<String, Event<?>> kafkaTemplate;

    public KafkEventProducer(@Qualifier("kafkaEventTemplate") KafkaTemplate<String, Event<?>> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Event<?> event) {
        LOGGER.info("Producing message {}", event.getMessage());
        this.kafkaTemplate.send(KafkaEventConfig.TOPIC_EVENT, event);
    }

}