package com.bokeh.post.api.websocket.common.config

import com.bokeh.post.adapter.kafka.common.constant.ConsumerGroup
import com.bokeh.post.api.websocket.common.properties.KafkaConsumerProperties
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.UUIDDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate
import org.springframework.kafka.support.serializer.JsonDeserializer
import reactor.kafka.receiver.ReceiverOptions
import java.util.*

@Configuration
class KafkaConsumerConfig(
    private val kafkaConsumerProperties: KafkaConsumerProperties
) {

    @Bean
    fun postConsumerTemplate(receiverOptions: ReceiverOptions<UUID, Any>): ReactiveKafkaConsumerTemplate<UUID, Any> {
        return ReactiveKafkaConsumerTemplate(receiverOptions)
    }

    @Bean
    fun kafkaReceiverOptions(): ReceiverOptions<UUID, Any> {
        return ReceiverOptions
            .create<UUID?, Any?>(consumerProps())
            .subscription(kafkaConsumerProperties.topics)
    }

    private fun consumerProps(): Map<String, Any> {
        val props: MutableMap<String, Any> = HashMap()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaConsumerProperties.bootstrapServers
        props[ConsumerConfig.GROUP_ID_CONFIG] = ConsumerGroup.POST.name
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = UUIDDeserializer::class.java
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = JsonDeserializer::class.java
        return props
    }

}
