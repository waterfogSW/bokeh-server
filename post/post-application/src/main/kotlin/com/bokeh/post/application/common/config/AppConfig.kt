package com.bokeh.post.application.common.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["com.bokeh.post.application"], lazyInit = true)
class AppConfig
