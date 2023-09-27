package com.bokeh.user.application.user.port.`in`.command

import com.bokeh.user.application.user.vo.UserAccessToken
import com.bokeh.user.application.user.vo.UserRefreshToken
import java.util.*

interface UserRefreshTokenCommandUseCase {

    fun refreshToken(command: Command): Result
    data class Command(
        val userId: UUID,
        val refreshTokenString: String
    )

    data class Result(
        val accessToken: UserAccessToken,
        val refreshToken: UserRefreshToken,
    )


}
