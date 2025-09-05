package com.globalbooks.ordersservice;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME = "order.events";

    @Bean
    public Exchange orderEventsExchange() {
        return new FanoutExchange(EXCHANGE_NAME);
    }
}