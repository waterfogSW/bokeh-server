package com.bokeh.post.application.post.port.out

import com.bokeh.post.domain.post.domain.Post

interface PostSocketPort {

    fun sendPostCreatedEvent(post: Post)
}
