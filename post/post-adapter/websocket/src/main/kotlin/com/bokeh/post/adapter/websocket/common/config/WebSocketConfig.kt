package com.bokeh.post.adapter.websocket.common.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

@Configuration
@EnableWebSocketMessageBroker
@ComponentScan(basePackages = ["com.bokeh.post.adapter.websocket"])
class WebSocketConfig : WebSocketMessageBrokerConfigurer {
    companion object {
        const val STOMP_ENDPOINT = "/events"
        const val ALLOWED_ORIGINS = "*"
        const val BROKER_DESTINATION_PREFIX = "/topic"
        const val APPLICATION_DESTINATION_PREFIX = "/app"
    }

    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        registry.enableSimpleBroker(BROKER_DESTINATION_PREFIX)
        registry.setApplicationDestinationPrefixes(APPLICATION_DESTINATION_PREFIX)
    }

    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry
            .addEndpoint(STOMP_ENDPOINT)
            .setAllowedOrigins(ALLOWED_ORIGINS)
            .withSockJS()
    }
}
