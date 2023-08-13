package com.bokeh.user.application.vo

import com.bokeh.user.domain.entity.User
import java.util.*

data class UserInfo(
    val id: UUID,
    val username: String,
    val email: String,
) {
    companion object {
        fun from(user: User) = UserInfo(
            id = user.id,
            username = user.username,
            email = user.email,
        )
    }
}
