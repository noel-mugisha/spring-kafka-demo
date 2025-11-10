package com.demo.consumer.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WikimediaConsumer {
    @KafkaListener(topics = "wikimedia-stream", groupId = "wikimedia-group")
    public void consumeMessage(String message) {
        log.info("Wikimedia consumer received message: {}", message);
        // You can make additional changes needed with the data
    }
}
