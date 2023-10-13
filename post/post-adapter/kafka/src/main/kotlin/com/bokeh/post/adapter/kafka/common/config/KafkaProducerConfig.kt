package com.bokeh.post.adapter.kafka.common.config

import com.bokeh.post.adapter.kafka.common.properties.KafkaProducerProperties
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import org.springframework.kafka.support.serializer.JsonSerializer
import reactor.kafka.sender.SenderOptions
import java.util.*

@Configuration
class KafkaProducerConfig(
    private val kafkaProducerProperties: KafkaProducerProperties
) {

    @Bean
    fun postProducerTemplate(): ReactiveKafkaProducerTemplate<String, Any> {
        val senderOptions: SenderOptions<String, Any> = SenderOptions.create(producerProps())
        return ReactiveKafkaProducerTemplate(senderOptions)
    }

    private fun producerProps(): Map<String, Any> {
        val props: MutableMap<String, Any> = HashMap()
        props[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaProducerProperties.bootstrapServers
        props[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        props[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = JsonSerializer::class.java
        props[JsonSerializer.ADD_TYPE_INFO_HEADERS] = true
        return props
    }

}
