package com.bokeh.post.adapter.kafka.adapter

import com.bokeh.post.adapter.kafka.common.properties.KafkaProducerProperties
import com.bokeh.post.adapter.kafka.dto.PostCreateEvent
import com.bokeh.post.application.post.port.out.PostEventPort
import com.bokeh.post.domain.post.domain.Post
import org.springframework.stereotype.Component

@Component
class PostKafkaAdapter(
    private val postKafkaProducer: PostKafkaProducer,
    private val postKafkaProducerProperties: KafkaProducerProperties,
) : PostEventPort {

    override fun sendCreateEvent(post: Post) {
        val event: PostCreateEvent = PostCreateEvent.from(post)
        val topic: String = postKafkaProducerProperties.postCreateTopic
        postKafkaProducer.publish(topic = topic, message = event)
    }

}
