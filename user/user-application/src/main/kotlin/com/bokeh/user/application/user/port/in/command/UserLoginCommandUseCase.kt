package com.bokeh.user.application.user.port.`in`.command

import com.bokeh.user.application.user.vo.UserAccessToken
import com.bokeh.user.application.user.vo.UserRefreshToken

interface UserLoginCommandUseCase {

    fun login(command: Command): Result
    data class Command(
        val email: String,
        val password: String
    )

    data class Result(
        val accessToken: UserAccessToken,
        val refreshToken: UserRefreshToken
    )
}
