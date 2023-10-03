package com.bokeh.user.adapter.persistence.common.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaAuditing
@ComponentScan(basePackages = ["com.bokeh.user.adapter.persistence"])
@EntityScan(basePackages = ["com.bokeh.user.adapter.persistence.entity"])
@EnableJpaRepositories(basePackages = ["com.bokeh.user.adapter.persistence.repository"])
class PersistenceConfig
