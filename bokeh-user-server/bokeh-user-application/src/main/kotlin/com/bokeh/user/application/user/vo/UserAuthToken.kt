package com.bokeh.user.application.user.vo

data class UserAuthToken(
    val token: String,
    val expiresIn: Long,
)
