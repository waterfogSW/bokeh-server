package com.bokeh.user.domain.user.domain

import java.util.*

data class UserAuth(
    val id: UUID,
    val username: String,
    val email: String,
    val role: Role,
) {

    fun getSubject(): String {
        return id.toString()
    }

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
            return UserAuth(
                id = user.id,
                username = user.username,
                email = user.email,
                role = user.role,
            )
        }
    }
}
