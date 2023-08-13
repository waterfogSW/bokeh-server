package com.bokeh.user.api.auth.dto

data class AuthLoginRequest(
    val email: String,
    val password: String,
)
