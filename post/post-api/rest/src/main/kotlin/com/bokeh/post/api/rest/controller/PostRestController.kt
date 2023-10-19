package com.bokeh.post.api.rest.controller

import com.bokeh.post.api.rest.dto.PostCreateRequest
import com.bokeh.post.application.post.port.`in`.command.PostCreateCommandUseCase
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("posts")
class PostRestController(
    private val postCreateCommandUseCase: PostCreateCommandUseCase,
) {

    @PostMapping("")
    fun createPost(
        @RequestHeader("User-Id") userId: UUID,
        @RequestBody postCreateRequest: PostCreateRequest
    ) {
        val command = PostCreateCommandUseCase.Command(
            title = postCreateRequest.title,
            content = postCreateRequest.content,
            writerId = userId,
            tags = postCreateRequest.tags,
        )

        postCreateCommandUseCase.create(command = command)
    }
}
