package com.bokeh.user.application.user.vo

data class UserLoginToken(
    val accessToken: UserAccessToken,
    val refreshToken: UserRefreshToken,
)
