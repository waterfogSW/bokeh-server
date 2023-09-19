package com.bokeh.user.application.user.usecase

import com.bokeh.user.application.common.annotation.UseCase
import com.bokeh.user.application.user.port.`in`.UserAuthCommand
import com.bokeh.user.application.user.port.out.UserRefreshTokenPort
import com.bokeh.user.application.user.util.BCryptPasswordEncoder
import com.bokeh.user.application.user.util.UserTokenProvider
import com.bokeh.user.application.user.vo.UserAccessToken
import com.bokeh.user.application.user.vo.UserAuth
import com.bokeh.user.application.user.vo.UserLoginToken
import com.bokeh.user.application.user.vo.UserRefreshToken
import com.bokeh.user.domain.user.domain.User
import java.util.*

@UseCase
class UserAuthCommandUseCase(
    private val userQueryUseCase: UserQueryUseCase,
    private val userTokenProvider: UserTokenProvider,
    private val userRefreshTokenPort: UserRefreshTokenPort,
) : UserAuthCommand {

    override fun login(
        email: String,
        password: String,
    ): UserLoginToken {
        val user = userQueryUseCase.getUserByEmail(email = email)
        user.checkPasswordMatch(rawPassword = password, matchOperation = BCryptPasswordEncoder::matches)

        val userAuth: UserAuth = UserAuth.from(user)
        val accessToken: UserAccessToken = userTokenProvider.generateAccessToken(userAuth = userAuth)
        val refreshToken: UserRefreshToken = userTokenProvider.generateRefreshToken(userAuth = userAuth)

        userRefreshTokenPort.saveRefreshToken(userRefreshToken = refreshToken)

        return UserLoginToken(
            accessToken = accessToken,
            refreshToken = refreshToken,
        )
    }

    override fun refreshToken(
        userId: UUID,
        refreshTokenString: String,
    ): UserLoginToken {
        val refreshToken: UserRefreshToken = userRefreshTokenPort.getRefreshTokenByUserId(userId = userId)
            ?: throw IllegalArgumentException("Refresh token not found")
        refreshToken.checkTokenStringMatch(refreshToken.tokenString)

        val user: User = userQueryUseCase.getUserById(id = userId)
            ?: throw IllegalArgumentException("User not found")
        val userAuth: UserAuth = UserAuth.from(user)
        val accessToken: UserAccessToken = userTokenProvider.generateAccessToken(userAuth = userAuth)

        return UserLoginToken(
            accessToken = accessToken,
            refreshToken = refreshToken,
        )
    }

}
