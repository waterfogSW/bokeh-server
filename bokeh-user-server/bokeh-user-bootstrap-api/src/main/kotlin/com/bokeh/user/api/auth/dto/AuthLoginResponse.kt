package com.bokeh.user.api.auth.dto

import com.bokeh.user.application.user.vo.UserTokens

data class AuthLoginResponse(
    val accessToken: String,
    val refreshToken: String,
) {
    companion object {
        fun from(userTokens: UserTokens) = AuthLoginResponse(
            accessToken = userTokens.accessToken,
            refreshToken = userTokens.refreshToken,
        )
    }
}
