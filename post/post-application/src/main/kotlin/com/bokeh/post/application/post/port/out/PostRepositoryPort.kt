package com.bokeh.post.application.post.port.out

import com.bokeh.post.domain.post.domain.Post

interface PostRepositoryPort {
    fun save(post: Post): Post
}
