package com.bokeh.post.application.post.port.`in`.command

import com.bokeh.post.application.post.port.out.PostRepositoryPort
import com.bokeh.post.domain.post.domain.Post
import org.springframework.stereotype.Service

@Service
class PostCreateCommand(
    private val postRepositoryPort: PostRepositoryPort,
) : PostCreateCommandUseCase {

    override fun create(command: PostCreateCommandUseCase.Command): Post {
        val post = Post(
            title = command.title,
            content = command.content,
            writerId = command.writerId,
            tags = command.tags,
        )

        return postRepositoryPort.save(post)
    }

}
