package com.bokeh.post.application.post.port.`in`.command

import com.bokeh.post.application.post.port.out.PostPort
import com.bokeh.post.application.post.vo.CreatePostParam
import com.bokeh.post.domain.post.domain.Post
import org.springframework.stereotype.Service

@Service
class PostCommandUseCase(
    private val postPort: PostPort,
) : PostCommand {

    override fun createPost(param: CreatePostParam) {
        val newPost: Post = Post(
            title = param.title,
            content = param.content,
            writerId = param.writerId,
            tags = param.tags,
        )

        postPort.savePost(newPost)
    }

}
