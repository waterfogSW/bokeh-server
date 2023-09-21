package com.bokeh.post.domain.post.domain

import java.time.LocalDateTime
import java.util.*

data class Post(
    val id: UUID? = null,
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

    companion object {
        fun createWithGeneratedTagsByContent(
            title: String,
            content: String,
            writerId: UUID,
            tagGenerator: (String) -> Tags
        ): Post {
            return Post(
                title = title,
                content = content,
                writerId = writerId,
                tags = tagGenerator(content)
            )
        }
    }

}
