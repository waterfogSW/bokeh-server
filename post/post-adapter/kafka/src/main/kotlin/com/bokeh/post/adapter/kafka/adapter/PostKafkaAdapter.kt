package com.bokeh.post.adapter.kafka.adapter

import com.bokeh.post.adapter.kafka.common.config.KafkaTopic
import com.bokeh.post.application.post.port.out.PostEventPort
import com.bokeh.post.domain.post.domain.Post
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class PostKafkaAdapter(
    private val kafkaTemplate: KafkaTemplate<String, Post>,
) : PostEventPort {

    override fun sendCreateEvent(post: Post) {
        //TODO: add logging, transaction outbox pattern
        kafkaTemplate.send(KafkaTopic.POST_CREATE, post)
    }

}
