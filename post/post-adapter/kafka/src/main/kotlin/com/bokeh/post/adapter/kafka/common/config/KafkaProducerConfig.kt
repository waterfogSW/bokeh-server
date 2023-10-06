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
    fun postProducerTemplate(): ReactiveKafkaProducerTemplate<String, Post> {
        val senderOptions: SenderOptions<String, Post> = SenderOptions.create(producerProps())
        return ReactiveKafkaProducerTemplate(senderOptions)
    }

    private fun producerProps(): Map<String, Any> {
        val props: MutableMap<String, Any> = HashMap()
        props[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaProperties.bootstrapServers
        props[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        props[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = JsonSerializer::class.java
        props[ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG] = true
        return props
    }

}
