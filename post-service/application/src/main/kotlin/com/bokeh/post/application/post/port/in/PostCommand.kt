package com.bokeh.post.application.post.port.`in`

import com.bokeh.post.application.post.vo.CreatePostParam

interface PostCommand {
    fun createPost(param: CreatePostParam)
}
