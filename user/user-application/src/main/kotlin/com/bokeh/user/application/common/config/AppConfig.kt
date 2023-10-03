package com.bokeh.user.application.common.config

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["com.bokeh.user.application"], lazyInit = true)
@ConfigurationPropertiesScan(basePackages = ["com.bokeh.user.application.common.properties"])
class AppConfig
