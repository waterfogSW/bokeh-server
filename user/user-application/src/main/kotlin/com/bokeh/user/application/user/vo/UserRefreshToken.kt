package com.bokeh.user.application.user.vo

import java.util.*

data class UserRefreshToken(
    override val userId: UUID,
    override val tokenString: String,
    override val expiresIn: Long,
) : UserToken
