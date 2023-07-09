package ua.andrew1903.consumer.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ua.andrew1903.model.Message;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageListener {
    @KafkaListener(topics = "${kafka.topics.message-topic}")
    public void listen(Message message) {
        log.info("{}", message);
    }
}
