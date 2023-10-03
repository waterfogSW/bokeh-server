package com.bokeh.post.application.post.port.`in`.command

import java.util.*

interface PostCreateCommandUseCase {

    fun create(command: Command)
    data class Command(
        val title: String,
        val content: String,
        val writerId: UUID,
        val tags: List<String>
    )
}
