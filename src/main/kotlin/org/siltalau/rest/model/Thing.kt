package org.siltalau.rest.model

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime

@Document(collection="thing")
data class Thing(
        @Id
        val id: String?,

        val name: String? = null,

        @CreatedDate
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        val createdDate: LocalDateTime = LocalDateTime.now())