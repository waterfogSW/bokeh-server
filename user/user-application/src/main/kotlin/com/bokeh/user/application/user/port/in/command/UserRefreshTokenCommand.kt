package com.bokeh.user.application.user.port.`in`.command

import com.bokeh.user.application.user.port.`in`.query.GetUserQueryUseCase
import com.bokeh.user.application.user.port.out.UserRefreshTokenRepositoryPort
import com.bokeh.user.application.user.util.UserTokenProvider
import com.bokeh.user.application.user.vo.UserAccessToken
import com.bokeh.user.application.user.vo.UserRefreshToken
import com.bokeh.user.domain.user.domain.User
import com.bokeh.user.domain.user.domain.UserAuth
import org.springframework.stereotype.Service

@Service
class UserRefreshTokenCommand(
    private val getUserQueryUseCase: GetUserQueryUseCase,
    private val userTokenProvider: UserTokenProvider,
    private val userRefreshTokenRepositoryPort: UserRefreshTokenRepositoryPort,
) : UserRefreshTokenCommandUseCase {
    override fun refreshToken(
        command: UserRefreshTokenCommandUseCase.Command
    ): UserRefreshTokenCommandUseCase.Result {
        val refreshToken: UserRefreshToken = userRefreshTokenRepositoryPort.getByUserId(userId = command.userId)
            ?: throw IllegalArgumentException("Refresh token not found")

        require(refreshToken.tokenString == command.refreshTokenString) {
            "Refresh token is not match"
        }

        val user: User = getUserQueryUseCase.getById(id = command.userId)
        val userAuth: UserAuth = UserAuth.from(user)
        val accessToken: UserAccessToken = userTokenProvider.generateAccessToken(userAuth = userAuth)

        return UserRefreshTokenCommandUseCase.Result(
            accessToken = accessToken,
            refreshToken = refreshToken,
        )
    }

}
