package com.bokeh.post.adapter.kafka.common.config

import com.bokeh.post.adapter.kafka.common.properties.KafkaProperties
import com.bokeh.post.domain.post.domain.Post
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate


@EnableKafka
@Configuration
@ComponentScan(basePackages = ["com.bokeh.post.adapter.kafka"])
@ConfigurationPropertiesScan(basePackages = ["com.bokeh.post.adapter.kafka.common.properties"])
class KafkaConfig(
    private val kafkaProperties: KafkaProperties
) {

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, Post> {
        val config = mapOf<String, Any>(
            "bootstrap.servers" to kafkaProperties.bootstrapServers,
            "key.serializer" to "org.apache.kafka.common.serialization.StringSerializer",
            "value.serializer" to "org.springframework.kafka.support.serializer.JsonSerializer",
        )
        val producerFactory = DefaultKafkaProducerFactory<String, Post>(config)
        return KafkaTemplate(producerFactory)
    }

}
