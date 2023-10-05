package com.bokeh.post.adapter.kafka.common.config

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka


@EnableKafka
@Configuration
@ComponentScan(basePackages = ["com.bokeh.post.adapter.kafka"])
@ConfigurationPropertiesScan(basePackages = ["com.bokeh.post.adapter.kafka.common.properties"])
class KafkaConfig
