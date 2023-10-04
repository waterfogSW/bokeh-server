package com.bokeh.post.application.post.port.`in`.command

import com.bokeh.post.application.post.port.out.PostRepositoryPort
import com.bokeh.post.domain.post.domain.Post
import org.springframework.stereotype.Service

@Service
class PostPersistCommand(
    private val postRepositoryPort: PostRepositoryPort
) : PostPersistCommandUseCase {
    override fun persist(post: Post) {
        //TODO: message transaction, retry logic
        postRepositoryPort.save(post)
    }
}
