package com.bokeh.post.adapter.kafka.adapter

import com.bokeh.post.adapter.kafka.common.constant.KafkaTopic
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import org.springframework.stereotype.Component
import java.util.*

@Component
class PostKafkaProducer(
    private val reactiveKafkaProducerTemplate: ReactiveKafkaProducerTemplate<UUID, Any>,
) {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun send(topic: KafkaTopic, key: UUID, value: Any) {
        reactiveKafkaProducerTemplate
            .send(topic.name, key, value)
            .doOnSuccess { log.info("Send Post Create Event(Event ID : $key)") }
            .subscribe()
    }
}
