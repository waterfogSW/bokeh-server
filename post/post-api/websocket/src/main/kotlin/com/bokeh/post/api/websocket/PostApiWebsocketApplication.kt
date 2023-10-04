package com.bokeh.post.api.websocket

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
    ]
)
@ConfigurationPropertiesScan
class PostApiWebsocketApplication

fun main(args: Array<String>) {
    TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"))
    runApplication<PostApiWebsocketApplication>(*args)
}
