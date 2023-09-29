package com.bokeh.post.application.post.port.`in`.command

import com.bokeh.post.domain.post.domain.Post

interface PostCreateCommandUseCase {

    fun create(command: Command): Post
    data class Command(
        val title: String,
        val content: String,
        val writerId: String,
        val tags: List<String>,
    )
}
