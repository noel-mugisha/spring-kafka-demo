package com.demo.producer.stream;

import com.demo.producer.kafka.WikimediaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class WikimediaStreamConsumer {
    private final WikimediaProducer producer;
    private final WebClient webClient;

    public WikimediaStreamConsumer(WikimediaProducer producer, WebClient.Builder webClientBuilder) {
        this.producer = producer;
        this.webClient = webClientBuilder
                .baseUrl("https://stream.wikimedia.org/v2")
                .build();
    }

    public void consumeStreamAndPublish() {
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(log::info);
    }
}
