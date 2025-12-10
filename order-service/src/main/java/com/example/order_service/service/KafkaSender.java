package com.example.order_service.service;

import com.example.order_service.model.OrderDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaSender {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${order-service.topic.order-created:order-created}")
    private String orderCreatedTopic;

    public void sendOrderCreated(OrderDTO order) {
        log.info("Sending event to topic: {}, data: {}", orderCreatedTopic, order);
        kafkaTemplate.send(orderCreatedTopic, order);
    }

}
