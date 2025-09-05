package com.globalbooks.ordersservice;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.UUID;

@RestController
public class OrderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/orders")
    public Map<String, String> createOrder(@RequestBody Map<String, Object> orderPayload) {
        String orderId = "ORD-" + UUID.randomUUID().toString().substring(0, 8);
        System.out.println("New order received: " + orderId);

        // Publish an event to RabbitMQ
        rabbitTemplate.convertAndSend("order.events", "", "New order created: " + orderId);

        return Map.of(
                "orderId", orderId,
                "status", "PENDING"
        );
    }
}