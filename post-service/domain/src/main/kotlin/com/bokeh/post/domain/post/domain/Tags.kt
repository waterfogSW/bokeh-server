package com.bokeh.post.domain.post.domain

data class Tags(
    val value: List<Tag>
) {
    init {
        require(value.size in 1..10) {
            "tag size must be between 1 and 10"
        }
    }
}
