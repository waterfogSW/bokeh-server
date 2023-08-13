package com.bokeh.user.application.user.vo

import com.bokeh.user.domain.user.entity.Role
import com.bokeh.user.domain.user.entity.User
import java.util.*

data class UserInfo(
    val id: UUID?,
    val username: String,
    val email: String,
    val role: Role,
) {
    companion object {
        fun from(user: User) = UserInfo(
            id = user.id,
            username = user.username,
            email = user.email,
            role = user.role,
        )
    }
}
