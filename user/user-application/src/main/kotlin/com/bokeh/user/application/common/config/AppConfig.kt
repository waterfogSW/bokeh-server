package com.bokeh.user.application.common.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["com.bokeh.user.application"], lazyInit = true)
class AppConfig
