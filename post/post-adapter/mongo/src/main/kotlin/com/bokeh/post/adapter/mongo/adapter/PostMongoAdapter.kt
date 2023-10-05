package com.bokeh.post.adapter.mongo.adapter

import com.bokeh.post.application.post.port.out.PostRepositoryPort
import com.bokeh.post.domain.post.domain.Post
import org.springframework.stereotype.Component

@Component
class PostMongoAdapter : PostRepositoryPort {

    override fun save(post: Post): Post {
        TODO("implement with reactive mongo")
    }
}
