package com.bokeh.post.application.post.usecase

import com.bokeh.post.application.common.annotation.UseCase
import com.bokeh.post.application.post.port.`in`.PostCommand
import com.bokeh.post.application.post.port.out.PostPort
import com.bokeh.post.application.post.vo.CreatePostParam
import com.bokeh.post.domain.post.domain.Post

@UseCase
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
