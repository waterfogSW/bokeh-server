package com.bokeh.post.application.post.port.`in`.command

import com.bokeh.post.domain.post.domain.Post
import com.bokeh.post.domain.post.domain.Tags
import java.util.*

interface PostCreateCommandUseCase {

    fun create(command: Command): Post
    data class Command(
        val title: String,
        val content: String,
        val writerId: UUID,
        val tags: Tags,
    )
}
