package com.bokeh.post.adapter.kafka.dto

import com.bokeh.post.domain.post.domain.Post

data class PostCreatEvent(
    override val data: Post,
) : KafkaEvent(data = data) {

    companion object {
        fun from(post: Post): PostCreatEvent {
            return PostCreatEvent(
                data = post,
            )
        }
    }
}
