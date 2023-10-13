package com.bokeh.post.api.websocket.controller

import com.bokeh.post.adapter.kafka.common.constant.KafkaTopic
import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.context.event.EventListener
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate
import org.springframework.stereotype.Controller
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Controller
class PostKafkaConsumer(
    private val reactiveKafkaConsumerTemplate: ReactiveKafkaConsumerTemplate<String, Any>
) {

    private val log = LoggerFactory.getLogger(this::class.java)

    @EventListener(ApplicationStartedEvent::class)
    fun consumePostCreateEvent(): Flux<Any> {
        return reactiveKafkaConsumerTemplate
            .receiveAutoAck()
            .filter { it.topic() == KafkaTopic.POST_CREATE.name }
            .flatMap { record ->
                processTopic1(record.value())
                    .then(Mono.just(record))
            }
            .map { record -> record.value() }
            .doOnNext { log.info("successfully consumed") }
            .doOnError { throwable -> log.error("something bad happened while consuming : {}", throwable.message) }
    }

    fun processTopic1(value: Any): Flux<Any> {
        log.info("Processed topic1 message: $value")
        return Flux.just(value)
    }

}
