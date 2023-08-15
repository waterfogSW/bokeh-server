package com.bokeh.user.application.user.vo

import com.bokeh.user.domain.user.domain.Role
import com.bokeh.user.domain.user.domain.User
import java.util.*

data class UserAuth(
    val id: UUID,
    val username: String,
    val email: String,
    val role: Role,
) {

    fun toClaims(): Map<String, String> {
        return mapOf(
            "id" to id.toString(),
            "username" to username,
            "email" to email,
            "role" to role.toString(),
        )
    }

    companion object {
        fun from(user: User): UserAuth {
            val id = user.id ?: throw IllegalArgumentException("User id must not be null")
            return UserAuth(
                id = id,
                username = user.username,
                email = user.email,
                role = user.role,
            )
        }
    }
}
