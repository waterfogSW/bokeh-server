package com.bokeh.post.api.websocket.controller

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class PostWebsocketController {
    @MessageMapping("/posts")
    @SendTo("topic/posts")
    fun postEvent() {
        return
    }


}
