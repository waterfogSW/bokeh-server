package com.bokeh.post.api.websocket.common.config

import com.bokeh.post.adapter.kafka.common.constant.ConsumerGroup
import com.bokeh.post.adapter.kafka.common.constant.KafkaTopic
import com.bokeh.post.api.websocket.common.properties.KafkaConsumerProperties
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
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

    companion object {
        private const val ALL_PACKAGE = "*"
    }

    @Bean
    fun postConsumerTemplate(receiverOptions: ReceiverOptions<String, Any>): ReactiveKafkaConsumerTemplate<String, Any> {
        return ReactiveKafkaConsumerTemplate(receiverOptions)
    }

    @Bean
    fun kafkaReceiverOptions(): ReceiverOptions<String, Any> {
        return ReceiverOptions.create<String, Any>(consumerProps()).subscription(KafkaTopic.getTopicNames())
    }

    private fun consumerProps(): Map<String, Any> {
        val props: MutableMap<String, Any> = HashMap()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaConsumerProperties.bootstrapServers
        props[ConsumerConfig.GROUP_ID_CONFIG] = ConsumerGroup.POST.name
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = JsonDeserializer::class.java
        props[JsonDeserializer.USE_TYPE_INFO_HEADERS] = true
        props[JsonDeserializer.TRUSTED_PACKAGES] = ALL_PACKAGE
        return props
    }

}
