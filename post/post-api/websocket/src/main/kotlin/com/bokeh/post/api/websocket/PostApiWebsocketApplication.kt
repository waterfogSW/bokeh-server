package com.bokeh.post.api.websocket

import com.bokeh.post.adapter.kafka.common.config.KafkaConfig
import com.bokeh.post.adapter.websocket.common.config.WebSocketConfig
import com.bokeh.post.application.common.config.AppConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import java.util.*

@SpringBootApplication
@Import(
    value = [
        AppConfig::class,
        KafkaConfig::class,
        WebSocketConfig::class,
    ]
)
@ConfigurationPropertiesScan
class PostApiWebsocketApplication

fun main(args: Array<String>) {
    TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"))
    runApplication<PostApiWebsocketApplication>(*args)
}
