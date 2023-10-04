package com.bokeh.post.adapter.kafka.common.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "kafka")
data class KafkaProperties(
    val bootstrapServers: String,
)
