package com.bokeh.user.api.user.dto

import com.bokeh.user.application.user.vo.UserTokens

data class UserAuthLoginResponse(
    val accessToken: String,
    val refreshToken: String,
) {
    companion object {
        fun from(userTokens: UserTokens) = UserAuthLoginResponse(
            accessToken = userTokens.accessToken,
            refreshToken = userTokens.refreshToken,
        )
    }
}
