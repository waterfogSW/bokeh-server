package com.bokeh.user.api.user.dto

import com.bokeh.user.application.user.vo.UserAccessToken
import com.bokeh.user.application.user.vo.UserLoginToken
import com.bokeh.user.application.user.vo.UserRefreshToken

data class UserAuthLoginResponse(
    val accessToken: UserAccessToken,
    val refreshToken: UserRefreshToken,
) {
    companion object {
        fun from(userLoginToken: UserLoginToken) = UserAuthLoginResponse(
            accessToken = userLoginToken.accessToken,
            refreshToken = userLoginToken.refreshToken,
        )
    }
}
