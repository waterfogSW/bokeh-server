package com.bokeh.post.application.post.port.`in`.command

import com.bokeh.post.domain.post.domain.Post

interface PostCreatedEventSendCommandUseCase {

    fun send(post: Post)
}
