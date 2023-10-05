package com.bokeh.post.adapter.kafka.common.config

import com.bokeh.post.adapter.kafka.common.properties.KafkaProperties
import com.bokeh.post.domain.post.domain.Post
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import org.springframework.kafka.support.serializer.JsonSerializer
import reactor.kafka.sender.SenderOptions

@Configuration
class KafkaProducerConfig(
    private val kafkaProperties: KafkaProperties
) {

    @Bean
    fun ReactiveKafkaProducerTemplate(): ReactiveKafkaProducerTemplate<String, Post> {
        val producerProps: Map<String, Any> = mapOf<String, Any>(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaProperties.bootstrapServers,
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to JsonSerializer::class.java,
            ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG to true
        )
        val senderOptions: SenderOptions<String, Post> = SenderOptions.create(producerProps)
        return ReactiveKafkaProducerTemplate(senderOptions)
    }

}
