package com.ms.email.consumers

import com.ms.email.dtos.EmailDto
import com.ms.email.mappers.EmailModelMapper
import com.ms.email.services.EmailService
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class EmailConsumer(
    private val emailService: EmailService,
    private val emailModelMapper: EmailModelMapper
    ) {

    private val LOGGER = LoggerFactory.getLogger(EmailConsumer::class.java)

    @RabbitListener(queues = arrayOf("\${spring.rabbitmq.queue}")) // Informa que esse método será o ouvinte. Além disso o RabbitAdmin criará a fila automaticamente no Broker
    fun listen(@Payload emailDto: EmailDto) {
        LOGGER.info("Recebendo mensagem da fila ms-email...")
        val emailModel = emailModelMapper.map(emailDto)
        emailService.sendEmail(emailModel)
        LOGGER.info("Email Status: {}", emailModel.statusEmail)
    }

}