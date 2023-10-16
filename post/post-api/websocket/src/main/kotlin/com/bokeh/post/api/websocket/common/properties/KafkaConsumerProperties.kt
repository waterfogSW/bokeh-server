package com.bokeh.post.api.websocket.common.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "kafka.consumer")
data class KafkaConsumerProperties(
    val bootstrapServers: String,
    val groupId: String,
)
