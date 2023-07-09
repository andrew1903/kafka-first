package ua.andrew1903.producer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.andrew1903.model.Message;
import ua.andrew1903.producer.kafka.Topics;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/producer")
public class ProducerController {
    private final AtomicInteger counter = new AtomicInteger();

    private final Topics topics;
    private final KafkaTemplate<String, Message> template;

    @GetMapping("/send")
    public Message send() {
        var message = new Message("Message #" + counter.incrementAndGet());
        template.send(topics.messageTopic(), message);
        return message;
    }
}
