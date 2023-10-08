package com.bokeh.post.adapter.kafka.adapter

import com.bokeh.post.adapter.kafka.common.constant.KafkaTopic
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import reactor.kafka.sender.SenderResult
import java.util.*

@Component
class PostKafkaProducer(
    private val reactiveKafkaProducerTemplate: ReactiveKafkaProducerTemplate<UUID, Any>,
) {

    fun send(
        topic: KafkaTopic,
        key: UUID,
        value: Any
    ): Mono<SenderResult<Void>> {
        return reactiveKafkaProducerTemplate.send(topic.name, key, value)
    }
}
