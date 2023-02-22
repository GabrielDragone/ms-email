package com.ms.email.repositories

import com.ms.email.models.EmailModel
import org.springframework.data.jpa.repository.JpaRepository

interface EmailRepository: JpaRepository<EmailModel, Long> {
}