package com.bokeh.user.domain.user.domain

import com.bokeh.user.domain.user.constant.ErrorMessage
import java.util.*

data class User(
    val id: UUID? = null,
    val username: String,
    val password: String,
    val email: String,
    val role: Role = Role.USER,
) {
    init {
        require(username.isNotBlank() && username.length in 3..10) {
            ErrorMessage.INVALID_USERNAME_SET.msg
        }

        val emailRegex = "[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}".toRegex()
        require(email.isNotBlank() && emailRegex.matches(email)) {
            ErrorMessage.INVALID_EMAIL_SET.msg
        }
    }

    fun checkPasswordMatch(
        rawPassword: String,
        matchOperation: (String, String) -> Boolean
    ) {
        require(matchOperation(rawPassword, password)) { ErrorMessage.INVALID_PASSWORD.msg }
    }

    companion object {
        fun validatePassword(rawPassword: String) {
            require(rawPassword.isNotBlank() && rawPassword.length in 8..20) {
                ErrorMessage.INVALID_PASSWORD_SET.msg
            }
        }
    }

}
