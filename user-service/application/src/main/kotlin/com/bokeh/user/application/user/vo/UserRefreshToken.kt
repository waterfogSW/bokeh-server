package com.bokeh.user.application.user.vo

import java.util.*

data class UserRefreshToken(
    override val userId: UUID,
    override val tokenString: String,
    override val expiresIn: Long,
) : UserToken {

    fun checkTokenStringMatch(refreshTokenString: String) {
        require(tokenString == refreshTokenString) {
            "Refresh token is not match"
        }
    }
    
}
