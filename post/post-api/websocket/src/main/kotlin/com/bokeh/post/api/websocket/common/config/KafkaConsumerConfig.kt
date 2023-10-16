package com.bokeh.post.api.websocket.common.config

import com.bokeh.post.api.websocket.common.properties.KafkaConsumerProperties
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@EnableKafka
@Configuration
class KafkaConsumerConfig(
    private val kafkaConsumerProperties: KafkaConsumerProperties
) {

    companion object {
        private const val ALL_PACKAGE = "*"
        private const val CONSUMER_COUNT = 3
        private const val CONSUMER_POLL_TIMEOUT = 3000L
    }

    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, Any> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, Any>()
        factory.consumerFactory = consumerFactory()
        factory.setConcurrency(CONSUMER_COUNT)
        factory.containerProperties.pollTimeout = CONSUMER_POLL_TIMEOUT
        return factory
    }

    @Bean
    fun consumerFactory(): ConsumerFactory<String, Any> {
        return DefaultKafkaConsumerFactory(consumerProps())
    }

    private fun consumerProps(): Map<String, Any> {
        val props: MutableMap<String, Any> = HashMap()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaConsumerProperties.bootstrapServers
        props[ConsumerConfig.GROUP_ID_CONFIG] = kafkaConsumerProperties.groupId
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = JsonDeserializer::class.java
        props[JsonDeserializer.USE_TYPE_INFO_HEADERS] = true
        props[JsonDeserializer.TRUSTED_PACKAGES] = ALL_PACKAGE
        return props
    }

}
