package com.bokeh.user.api.user.dto

import com.bokeh.user.application.user.vo.UserToken
import com.bokeh.user.application.user.vo.UserLoginToken

data class UserAuthLoginResponse(
    val accessToken: UserToken,
    val refreshToken: UserToken,
) {
    companion object {
        fun from(userLoginToken: UserLoginToken) = UserAuthLoginResponse(
            accessToken = userLoginToken.accessToken,
            refreshToken = userLoginToken.refreshToken,
        )
    }
}
