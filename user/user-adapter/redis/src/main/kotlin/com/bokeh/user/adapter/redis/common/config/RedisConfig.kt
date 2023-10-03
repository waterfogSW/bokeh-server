package com.bokeh.user.adapter.redis.common.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories


@Configuration
@ComponentScan(basePackages = ["com.bokeh.user.adapter.redis"])
@EnableRedisRepositories(basePackages = ["com.bokeh.user.adapter.redis.repository"])
class RedisConfig {
    @Bean
    fun redisConnectionFactory(): LettuceConnectionFactory {
        return LettuceConnectionFactory(RedisStandaloneConfiguration())
    }

}
