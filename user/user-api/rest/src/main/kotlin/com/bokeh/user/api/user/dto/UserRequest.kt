package com.bokeh.user.api.user.dto

data class UserLoginRequest(
    val email: String,
    val password: String,
)

data class UserCreateRequest(
    val username: String,
    val password: String,
    val email: String,
)

data class UserLogoutRequest(
    val email: String,
)
