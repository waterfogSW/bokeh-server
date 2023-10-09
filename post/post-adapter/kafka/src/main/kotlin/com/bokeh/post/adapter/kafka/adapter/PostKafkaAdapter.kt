package com.bokeh.post.adapter.kafka.adapter

import com.bokeh.post.adapter.kafka.common.constant.KafkaTopic
import com.bokeh.post.adapter.kafka.dto.PostCreatEvent
import com.bokeh.post.application.post.port.out.PostEventPort
import com.bokeh.post.domain.post.domain.Post
import org.springframework.stereotype.Component

@Component
class PostKafkaAdapter(
    private val postKafkaProducer: PostKafkaProducer
) : PostEventPort {

    override fun sendCreateEvent(post: Post) {
        val event: PostCreatEvent = PostCreatEvent.from(post)
        postKafkaProducer.send(topic = KafkaTopic.POST_CREATE, key = event.id, value = event)
    }

}
