package com.bokeh.post.application.post.port.`in`.command

import com.bokeh.post.application.post.port.out.PostPort
import com.bokeh.post.application.post.vo.CreatePostParam
import com.bokeh.post.domain.post.domain.Post
import org.springframework.stereotype.Service

@Service
class PostCommand(
    private val postPort: PostPort,
) : PostCreateCommandUseCase {

    override fun create(command: PostCreateCommandUseCase.Command): Post {
        TODO("Not yet implemented")
    }


}
