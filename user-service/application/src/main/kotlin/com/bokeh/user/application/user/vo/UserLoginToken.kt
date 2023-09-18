package com.bokeh.user.application.user.vo

data class UserLoginToken(
    val accessToken: UserToken,
    val refreshToken: UserToken,
)
