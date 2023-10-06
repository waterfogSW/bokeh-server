package com.bokeh.post.adapter.kafka.adapter

import com.bokeh.post.adapter.kafka.common.config.KafkaTopic
import com.bokeh.post.application.post.port.out.PostEventPort
import com.bokeh.post.domain.post.domain.Post
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import org.springframework.stereotype.Component

@Component
class PostKafkaAdapter(
    private val reactiveKafkaProducerTemplate: ReactiveKafkaProducerTemplate<String, Post>,
) : PostEventPort {

    private val log = LoggerFactory.getLogger(javaClass)

    override fun sendCreateEvent(post: Post) {
        //TODO: add logging, transaction outbox pattern
        reactiveKafkaProducerTemplate
            .send(KafkaTopic.POST_CREATE, post)
            .doOnSuccess { log.info("Send Post Create Event - Post ID : ${post.id}") }
            .subscribe()
    }

}
