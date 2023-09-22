package com.bokeh.post.application.post.vo

import com.bokeh.post.domain.post.domain.Tags
import java.util.UUID

data class CreatePostParam(
    val title: String,
    val content: String,
    val writerId: UUID,
    val tags: Tags,
)
