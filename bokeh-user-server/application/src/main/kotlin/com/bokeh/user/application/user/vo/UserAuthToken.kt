package com.bokeh.user.application.user.vo

import java.util.*

data class UserAuthToken(
    val userId: UUID,
    val token: String,
    val expiresIn: Long,
)
