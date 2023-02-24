package com.ms.email.configs

import org.springframework.amqp.core.Queue
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration // Pro Spring saber que é uma classe de configuração
class RabbitMQConfig {

    @Value("\${spring.rabbitmq.queue}")
    private lateinit var queue: String

    @Bean
    fun queue(): Queue {
        return Queue(queue, true) // Se o RabbitMQ for interrompido, não perdemos as mensagens por estar true.
    }

    @Bean
    fun messageConverter(): Jackson2JsonMessageConverter { // Configura pra conseguirmos receber corretamente o payload de EmailDto
        return Jackson2JsonMessageConverter()
    }

}