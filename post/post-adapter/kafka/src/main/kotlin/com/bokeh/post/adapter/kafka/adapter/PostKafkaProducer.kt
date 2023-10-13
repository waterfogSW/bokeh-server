package com.bokeh.post.adapter.kafka.adapter

import com.bokeh.post.adapter.kafka.common.constant.KafkaTopic
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import org.springframework.stereotype.Component

@Component
class PostKafkaProducer(
    private val reactiveKafkaProducerTemplate: ReactiveKafkaProducerTemplate<String, Any>,
) {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun send(topic: KafkaTopic, event: Any) {
        reactiveKafkaProducerTemplate
            .send(topic.name, event)
            .doOnSuccess { log.info("Send Event: Topic: ${topic.name}, Event: $event") }
            .subscribe()
    }
}
