package com.bokeh.post.domain.post.domain

import java.time.LocalDateTime
import java.util.*

data class Post(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val content: String,
    val writerId: UUID,
    val tags: Tags,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now(),
) {

    init {
        require(title.isNotBlank()) { "title must not be blank" }
        require(title.length in 1..100) { "title length must be between 1 and 100" }
    }

}
