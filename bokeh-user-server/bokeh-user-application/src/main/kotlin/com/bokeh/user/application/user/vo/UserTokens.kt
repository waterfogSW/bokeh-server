package com.bokeh.user.application.user.vo

data class UserTokens(
    val accessToken: UserAuthToken,
    val refreshToken: UserAuthToken,
)
