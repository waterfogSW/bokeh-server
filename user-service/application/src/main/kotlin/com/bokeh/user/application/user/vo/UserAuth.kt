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

    fun getClaims(): Map<String, String> {
        return mapOf(
            USERNAME to username,
            EMAIL to email,
            ROLE to role.toString(),
        )
    }

    companion object {

        const val USERNAME = "username"
        const val EMAIL = "email"
        const val ROLE = "role"

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
