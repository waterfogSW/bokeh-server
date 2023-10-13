package com.bokeh.post.adapter.kafka.dto

import com.bokeh.post.domain.post.domain.Post

data class PostCreateEvent(
    val data: Post,
) {

    companion object {
        fun from(post: Post): PostCreateEvent {
            return PostCreateEvent(
                data = post,
            )
        }
    }
}
