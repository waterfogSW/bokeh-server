package com.bokeh.post.api.rest.dto

data class PostCreateRequest(
    val title: String,
    val content: String,
    val tags: List<String>
)
