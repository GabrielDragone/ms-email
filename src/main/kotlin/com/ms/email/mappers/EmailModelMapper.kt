package com.ms.email.mappers

import com.ms.email.dtos.EmailDto
import com.ms.email.models.EmailModel
import org.springframework.stereotype.Component

@Component
class EmailModelMapper: Mapper<EmailDto, EmailModel> {

    override fun map(dto: EmailDto): EmailModel {
        return EmailModel(
            ownerRef = dto.ownerRef,
            emailFrom = dto.emailFrom,
            emailTo = dto.emailTo,
            subject = dto.subject,
            text = dto.text,
        )
    }

}