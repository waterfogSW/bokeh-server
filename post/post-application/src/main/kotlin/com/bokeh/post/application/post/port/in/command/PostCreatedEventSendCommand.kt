package com.bokeh.post.application.post.port.`in`.command

import com.bokeh.post.application.post.port.out.PostSocketPort
import com.bokeh.post.domain.post.domain.Post
import org.springframework.stereotype.Service

@Service
class PostCreatedEventSendCommand(
    private val postSocketPort: PostSocketPort
): PostCreatedEventSendCommandUseCase {

    override fun send(post: Post) {
        postSocketPort.sendPostCreatedEvent(post = post)
    }

}
