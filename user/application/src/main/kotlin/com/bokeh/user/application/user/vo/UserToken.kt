package com.bokeh.user.application.user.vo

import java.util.*

interface UserToken {
    val userId: UUID
    val tokenString: String
    val expiresIn: Long
}
