package com.ms.email.services

import com.ms.email.enums.StatusEmail
import com.ms.email.models.EmailModel
import com.ms.email.repositories.EmailRepository
import org.slf4j.LoggerFactory
import org.springframework.mail.MailException
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class EmailService(
    private val emailRepository: EmailRepository,
    private val javaMailSender: JavaMailSender
) {

    private val LOGGER = LoggerFactory.getLogger(EmailService::class.java)

    fun sendEmail(emailModel: EmailModel): EmailModel {
        LOGGER.info("Iniciando envio de e-mail")

        emailModel.sendDateEmail = LocalDateTime.now()

        try {
            val message = SimpleMailMessage()
            message.from = emailModel.emailFrom
            message.setTo(emailModel.emailTo)
            message.subject = emailModel.subject
            message.text = emailModel.text

            javaMailSender.send(message)

            emailModel.statusEmail = StatusEmail.SENT
        } catch (e: MailException) {
            LOGGER.warn("Houve um erro ao enviar o e-mail: {}", e.message)
            emailModel.statusEmail = StatusEmail.ERROR
        } finally {
            LOGGER.info("Salvando e-mail")
            return emailRepository.save(emailModel)
        }

    }

}