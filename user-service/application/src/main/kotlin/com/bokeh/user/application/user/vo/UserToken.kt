package com.bokeh.user.application.user.vo

import java.util.*

data class UserToken(
    val userId: UUID,
    val token: String,
    val expiresIn: Long,
)
