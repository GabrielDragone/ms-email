package com.ms.email.controllers

import com.ms.email.dtos.EmailDto
import com.ms.email.mappers.EmailModelMapper
import com.ms.email.models.EmailModel
import com.ms.email.services.EmailService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.BeanUtils
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController("/api/v1/emails")
class EmailController(
    private val emailService: EmailService,
    private val emailModelMapper: EmailModelMapper
) {

    @PostMapping("/sending-email")
    @Operation(description = "Endpoint de envio de e-mail")
    fun sendingEmail(@RequestBody @Valid emailDto: EmailDto): ResponseEntity<EmailModel> {
        val emailModel = emailModelMapper.map(emailDto)
        emailService.sendEmail(emailModel)
        return ResponseEntity(emailModel, HttpStatus.CREATED)
    }


}