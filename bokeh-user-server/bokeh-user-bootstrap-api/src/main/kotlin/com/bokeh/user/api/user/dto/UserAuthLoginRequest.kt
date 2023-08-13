package com.bokeh.user.api.user.dto

data class UserAuthLoginRequest(
    val email: String,
    val password: String,
)
