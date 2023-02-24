package com.ms.email.repositories

import com.ms.email.models.EmailModel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

//interface EmailRepository: JpaRepository<EmailModel, Long> {
interface EmailRepository: JpaRepository<EmailModel, UUID> {
}