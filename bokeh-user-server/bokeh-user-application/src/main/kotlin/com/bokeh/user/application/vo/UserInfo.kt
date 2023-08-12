package com.bokeh.user.application.vo

import java.util.UUID

data class UserInfo(
    val id: UUID,
    val username: String,
    val email: String,
)
