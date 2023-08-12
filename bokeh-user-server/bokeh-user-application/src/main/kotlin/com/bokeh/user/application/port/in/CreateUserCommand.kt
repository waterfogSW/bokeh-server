package com.bokeh.user.application.port.`in`

import java.util.*

data class CreateUserCommand(
    val username: String,
    val password: String,
    val email: String,
)
