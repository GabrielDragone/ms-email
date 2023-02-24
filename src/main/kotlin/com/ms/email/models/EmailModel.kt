package com.ms.email.models

import com.ms.email.enums.StatusEmail
import java.io.Serializable
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "TB_EMAIL") // Nome da tabela que será gerada
data class EmailModel(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    val emailId: Long? = null, // Retirado de Long e passado pra UUID para não termos conflito entre ID's de sistemas diferentes e garantir que esses sejam realmente unicos.
    val emailId: UUID? = null,
    val ownerRef: String? = null,
    val emailFrom: String? = null,
    val emailTo: String? = null,
    val subject: String? = null, // Todos esses campos que são Strings, são limitados a 255 caracteres.
    @Column(columnDefinition = "TEXT") // Aqui informando essa definição, poderemos informar mais de 255 caracteres.
    val text: String? = null,
    var sendDateEmail: LocalDateTime? = null,
    var statusEmail: StatusEmail? = null,
): Serializable {
    companion object {
        private val serialVersionUid: Long = 1
    }
}