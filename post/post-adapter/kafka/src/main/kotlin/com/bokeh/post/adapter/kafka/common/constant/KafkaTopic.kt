package com.bokeh.post.adapter.kafka.common.constant

enum class KafkaTopic {
    POST_CREATE;


    companion object {
        fun getTopicNames(): List<String> {
            return entries.map { it.name }
        }
    }
}
