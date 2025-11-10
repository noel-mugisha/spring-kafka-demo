package com.demo.producer.controllers;

import com.demo.producer.kafka.WikimediaProducer;
import com.demo.producer.stream.WikimediaStreamConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/wikimedia")
public class WikimediaController {
    private final WikimediaStreamConsumer streamConsumer;
    private final WikimediaProducer producer;

    @GetMapping
    public ResponseEntity<Void> startStreamPublishing () {
        streamConsumer.consumeStreamAndPublish();
        return ResponseEntity.ok().build();
    }
}
