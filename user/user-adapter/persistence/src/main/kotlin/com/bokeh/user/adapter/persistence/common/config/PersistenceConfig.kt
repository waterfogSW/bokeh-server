package com.bokeh.user.adapter.persistence.common.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@Configuration
@EnableJpaAuditing
@ComponentScan(basePackages = ["com.bokeh.user.adapter.persistence"])
class PersistenceConfig
