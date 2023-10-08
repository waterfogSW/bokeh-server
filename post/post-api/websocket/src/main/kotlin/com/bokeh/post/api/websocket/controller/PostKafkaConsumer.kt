package com.bokeh.post.api.websocket.controller

import com.bokeh.post.domain.post.domain.Post
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.context.event.EventListener
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate
import org.springframework.stereotype.Controller

@Controller
class PostKafkaConsumer(
    private val kafkaConsumerTemplate: ReactiveKafkaConsumerTemplate<String, Post>
) {

    private val log = LoggerFactory.getLogger(this::class.java)

    @EventListener(ApplicationStartedEvent::class)
    fun consumePostEvent() {
        kafkaConsumerTemplate
            .receiveAutoAck()
            .map { it.value() }
            .doOnNext { log.info("Consume Post Event: $it") }

    }

}
