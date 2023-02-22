package com.ms.email.dtos

import javax.persistence.Column
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class EmailDto (
    @NotBlank(message = "O campo ownerRef é obrigatório!")
    val ownerRef: String,
    @NotBlank(message = "O campo emailFrom é obrigatório!")
    @Email // Verifica se é um e-mail válido
    val emailFrom: String,
    @NotBlank(message = "O campo emailTo é obrigatório!")
    @Email
    val emailTo: String,
    @NotBlank(message = "O campo subject é obrigatório!")
    val subject: String,
    @NotBlank(message = "O campo text é obrigatório!")
    val text: String,
)