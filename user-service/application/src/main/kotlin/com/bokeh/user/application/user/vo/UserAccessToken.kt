package com.bokeh.user.application.user.vo

import java.util.*

data class UserAccessToken(
    override val userId: UUID,
    override val tokenString: String,
    override val expiresIn: Long,
) : UserToken
