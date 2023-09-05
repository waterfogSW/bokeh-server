package com.bokeh.user.api.user.dto

import com.bokeh.user.application.user.vo.CreateUserParam

data class UserCreateRequest(
    val username: String,
    val password: String,
    val email: String,
) {
    fun toParam() = CreateUserParam(
        username = username,
        password = password,
        email = email,
    )
}
