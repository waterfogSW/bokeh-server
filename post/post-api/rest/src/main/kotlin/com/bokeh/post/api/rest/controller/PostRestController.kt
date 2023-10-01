package com.bokeh.post.api.rest.controller

import com.bokeh.post.api.rest.dto.PostCreateRequest
import com.bokeh.post.application.post.port.`in`.command.PostCreateCommandUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
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
