package com.bokeh.post.adapter.kafka.common.config

import com.bokeh.post.adapter.kafka.common.properties.KafkaProperties
import com.bokeh.post.domain.post.domain.Post
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate
import org.springframework.kafka.support.serializer.JsonDeserializer
import reactor.kafka.receiver.ReceiverOptions

@Configuration
class KafkaConsumerConfig(
    private val kafkaProperties: KafkaProperties
) {

    @Bean
    fun postConsumerTemplate(): ReactiveKafkaConsumerTemplate<String, Post> {
        val receiverOptions: ReceiverOptions<String, Post> = ReceiverOptions.create(consumerProps())
        return ReactiveKafkaConsumerTemplate(receiverOptions)
    }

    private fun consumerProps(): Map<String, Any> {
        val props: MutableMap<String, Any> = HashMap()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaProperties.bootstrapServers
        props[ConsumerConfig.GROUP_ID_CONFIG] = ConsumerGroup.POST_CONSUMER_GROUP
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = JsonDeserializer::class.java
        return props
    }

}
