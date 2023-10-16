package com.bokeh.post.adapter.kafka.adapter

import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class PostKafkaProducer(
    private val kafkaTemplate: KafkaTemplate<String, Any>,
) {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun publish(topic: String, message: Any) {
        kafkaTemplate
            .send(topic, message)
            .thenAccept { log.info("Published message: {} to topic: {}", message, topic) }
    }
}
