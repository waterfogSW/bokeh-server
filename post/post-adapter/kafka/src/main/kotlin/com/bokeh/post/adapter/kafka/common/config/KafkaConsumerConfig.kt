package com.bokeh.post.adapter.kafka.common.config

import com.bokeh.post.adapter.kafka.common.constant.ConsumerGroup
import com.bokeh.post.adapter.kafka.common.properties.KafkaProperties
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.UUIDDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate
import org.springframework.kafka.support.serializer.JsonDeserializer
import reactor.kafka.receiver.ReceiverOptions
import java.util.*
import kotlin.collections.HashMap

@Configuration
class KafkaConsumerConfig(
    private val kafkaProperties: KafkaProperties
) {

    @Bean
    fun postConsumerTemplate(): ReactiveKafkaConsumerTemplate<UUID, Any> {
        val receiverOptions: ReceiverOptions<UUID, Any> = ReceiverOptions.create(consumerProps())
        return ReactiveKafkaConsumerTemplate(receiverOptions)
    }

    private fun consumerProps(): Map<String, Any> {
        val props: MutableMap<String, Any> = HashMap()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaProperties.bootstrapServers
        props[ConsumerConfig.GROUP_ID_CONFIG] = ConsumerGroup.POST
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = UUIDDeserializer::class.java
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = JsonDeserializer::class.java
        return props
    }

}
