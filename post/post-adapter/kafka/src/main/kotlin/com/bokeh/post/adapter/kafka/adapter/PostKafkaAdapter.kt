package com.bokeh.post.adapter.kafka.adapter

import com.bokeh.post.application.post.port.out.PostEventPort
import com.bokeh.post.domain.post.domain.Post
import org.springframework.stereotype.Component

@Component
class PostKafkaAdapter(

): PostEventPort {
    override fun create(post: Post) {
        TODO("Not yet implemented")
    }
}
