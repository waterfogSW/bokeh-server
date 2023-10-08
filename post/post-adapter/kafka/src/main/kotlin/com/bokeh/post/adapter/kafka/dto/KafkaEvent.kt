package com.bokeh.post.adapter.kafka.dto

import java.util.*

abstract class KafkaEvent(
    val id: UUID = UUID.randomUUID(),
    open val data: Any
)
