package com.bokeh.post.api.websocket.controller

import com.bokeh.post.adapter.kafka.dto.PostCreateEvent
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Controller

@Controller
class PostKafkaConsumer {

    private val log = LoggerFactory.getLogger(this::class.java)

    @KafkaListener(topics = ["\${kafka.consumer.post-create-topic}"])
    fun listenPostCreateMessage(postCreateEvent: PostCreateEvent) {
        log.info("Received PostCreateEvent: {}", postCreateEvent)
    }

}
