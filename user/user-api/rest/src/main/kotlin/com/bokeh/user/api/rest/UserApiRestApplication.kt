package com.bokeh.user.api.rest

import com.bokeh.user.adapter.persistence.common.config.PersistenceConfig
import com.bokeh.user.adapter.redis.common.config.RedisConfig
import com.bokeh.user.application.common.config.AppConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import java.util.*

@SpringBootApplication
@Import(
    value = [
        AppConfig::class,
        PersistenceConfig::class,
        RedisConfig::class,
    ]
)
@ConfigurationPropertiesScan
class UserApiRestApplication

fun main(args: Array<String>) {
    TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"))
    runApplication<UserApiRestApplication>(*args)
}
