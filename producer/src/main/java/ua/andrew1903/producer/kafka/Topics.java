package ua.andrew1903.producer.kafka;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("kafka.topics")
public record Topics(
    String messageTopic
) {
}
