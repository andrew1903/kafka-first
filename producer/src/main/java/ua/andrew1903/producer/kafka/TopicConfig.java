package ua.andrew1903.producer.kafka;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class TopicConfig {
    private final Topics topics;

    @Bean
    public NewTopic messageTopic() {
        return new NewTopic(topics.messageTopic(), 2, (short) 1);
    }
}
