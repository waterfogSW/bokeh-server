package com.bokeh.user.application.user.usecase

import com.bokeh.user.application.common.annotation.UseCase
import com.bokeh.user.application.user.port.`in`.UserAuthCommand
import com.bokeh.user.application.user.port.out.UserAuthPort
import com.bokeh.user.application.user.util.BCryptPasswordEncoder
import com.bokeh.user.application.user.util.UserTokenProvider
import com.bokeh.user.application.user.vo.UserAuth
import com.bokeh.user.application.user.vo.UserTokens

@UseCase
class UserAuthCommandUseCase(
    private val userQueryUseCase: UserQueryUseCase,
    private val userTokenProvider: UserTokenProvider,
    private val userAuthPort: UserAuthPort,
) : UserAuthCommand {

    override fun login(email: String, password: String): UserTokens {
        val user = userQueryUseCase.getUserByEmail(email = email)
        user.checkPasswordMatch(rawPassword = password, matchOperation = BCryptPasswordEncoder::matches)

        val userAuth = UserAuth.from(user)
        val accessToken = userTokenProvider.generateAccessToken(userAuth = userAuth)
        val refreshToken = userTokenProvider.generateRefreshToken(userAuth = userAuth)

        userAuthPort.saveRefreshToken(userId = userAuth.id, refreshToken = refreshToken)

        return UserTokens(
            accessToken = accessToken,
            refreshToken = refreshToken,
        )
    }

}
