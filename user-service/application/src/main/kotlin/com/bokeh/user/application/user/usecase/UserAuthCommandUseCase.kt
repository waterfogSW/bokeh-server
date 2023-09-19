package com.bokeh.user.application.user.usecase

import com.bokeh.user.application.common.annotation.UseCase
import com.bokeh.user.application.user.port.`in`.UserAuthCommand
import com.bokeh.user.application.user.port.out.UserTokenPort
import com.bokeh.user.application.user.util.BCryptPasswordEncoder
import com.bokeh.user.application.user.util.UserTokenProvider
import com.bokeh.user.application.user.vo.UserAccessToken
import com.bokeh.user.application.user.vo.UserAuth
import com.bokeh.user.application.user.vo.UserLoginToken
import com.bokeh.user.application.user.vo.UserRefreshToken

@UseCase
class UserAuthCommandUseCase(
    private val userQueryUseCase: UserQueryUseCase,
    private val userTokenProvider: UserTokenProvider,
    private val userTokenPort: UserTokenPort,
) : UserAuthCommand {

    override fun login(email: String, password: String): UserLoginToken {
        val user = userQueryUseCase.getUserByEmail(email = email)
        user.checkPasswordMatch(rawPassword = password, matchOperation = BCryptPasswordEncoder::matches)

        val userAuth: UserAuth = UserAuth.from(user)
        val accessToken: UserAccessToken = userTokenProvider.generateAccessToken(userAuth = userAuth)
        val refreshToken: UserRefreshToken = userTokenProvider.generateRefreshToken(userAuth = userAuth)

        userTokenPort.saveRefreshToken(userRefreshToken = refreshToken)

        return UserLoginToken(
            accessToken = accessToken,
            refreshToken = refreshToken,
        )
    }

}
