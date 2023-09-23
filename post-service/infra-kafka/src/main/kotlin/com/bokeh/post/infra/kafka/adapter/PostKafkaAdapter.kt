package com.bokeh.post.infra.kafka.adapter

import com.bokeh.post.application.post.port.out.PostPort
import com.bokeh.post.domain.post.domain.Post
import com.bokeh.user.framework.common.annotation.Adapter

@Adapter
class PostKafkaAdapter : PostPort {
    override fun savePost(newPost: Post) {
        TODO("Not yet implemented")
    }

}
