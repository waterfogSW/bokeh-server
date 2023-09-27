package com.bokeh.user.application.user.port.`in`.command

import com.bokeh.user.application.user.port.`in`.query.GetUserQueryUseCase
import com.bokeh.user.application.user.port.out.UserRefreshTokenRepositoryPort
import com.bokeh.user.application.user.util.BCryptPasswordEncoder
import com.bokeh.user.application.user.util.UserTokenProvider
import com.bokeh.user.application.user.vo.UserAccessToken
import com.bokeh.user.domain.user.domain.UserAuth
import com.bokeh.user.application.user.vo.UserRefreshToken
import org.springframework.stereotype.Service

@Service
class UserLoginCommand(
    val getUserQueryUseCase: GetUserQueryUseCase,
    val userRefreshTokenRepositoryPort: UserRefreshTokenRepositoryPort,
    val userTokenProvider: UserTokenProvider,
) : UserLoginCommandUseCase {
    override fun login(command: UserLoginCommandUseCase.Command): UserLoginCommandUseCase.Result {
        val user = getUserQueryUseCase.getByEmail(email = command.email)
        user.checkPasswordMatch(
            rawPassword = command.password,
            matchOperation = BCryptPasswordEncoder::matches
        )

        val userAuth: UserAuth = UserAuth.from(user)
        val accessToken: UserAccessToken = userTokenProvider.generateAccessToken(userAuth = userAuth)
        val refreshToken: UserRefreshToken = userTokenProvider.generateRefreshToken(userAuth = userAuth)

        userRefreshTokenRepositoryPort.save(userRefreshToken = refreshToken)

        return UserLoginCommandUseCase.Result(
            accessToken = accessToken,
            refreshToken = refreshToken,
        )
    }

}
