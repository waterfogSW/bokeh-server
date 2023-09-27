package com.bokeh.user.api.user.dto

import com.bokeh.user.application.user.port.`in`.command.UserLoginCommandUseCase
import com.bokeh.user.application.user.vo.UserAccessToken
import com.bokeh.user.application.user.vo.UserRefreshToken

data class UserLoginResponse(
    val accessToken: UserAccessToken,
    val refreshToken: UserRefreshToken,
) {
    companion object {
        fun from(result: UserLoginCommandUseCase.Result) = UserLoginResponse(
            accessToken = result.accessToken,
            refreshToken = result.refreshToken,
        )
    }
}
