package com.bokeh.post.application.post.port.`in`.command

import com.bokeh.post.application.post.port.out.PostMessagePort
import com.bokeh.post.domain.post.domain.Post
import com.bokeh.post.domain.post.domain.Tags
import org.springframework.stereotype.Service

@Service
class PostCreateCommand(
    private val postMessagePort: PostMessagePort,
) : PostCreateCommandUseCase {

    override fun create(command: PostCreateCommandUseCase.Command) {
        val tags: Tags = Tags.fromStrings(strings = command.tags)
        val post = Post(
            title = command.title,
            content = command.content,
            writerId = command.writerId,
            tags = tags,
        )

        postMessagePort.sendCreateEvent(post = post)
    }

}
