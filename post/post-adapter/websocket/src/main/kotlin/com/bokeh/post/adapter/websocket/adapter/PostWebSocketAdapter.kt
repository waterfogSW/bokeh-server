package com.bokeh.post.adapter.websocket.adapter

import com.bokeh.post.application.post.port.out.PostSocketPort
import com.bokeh.post.domain.post.domain.Post
import org.springframework.stereotype.Component
import org.springframework.messaging.simp.SimpMessagingTemplate


@Component
class PostWebSocketAdapter (
    private val simpMessagingTemplate: SimpMessagingTemplate
): PostSocketPort {

    companion object {
        private const val POST_CREATE_TOPIC = "/topic/posts/create"
    }


    override fun sendPostCreatedEvent(post: Post) {
        simpMessagingTemplate.convertAndSend(POST_CREATE_TOPIC, post)
    }
}
