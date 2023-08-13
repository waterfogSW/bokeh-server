package com.bokeh.user.application.auth.usecase

import com.bokeh.user.application.auth.port.`in`.AuthCommand
import com.bokeh.user.application.common.annotation.UseCase
import com.bokeh.user.application.common.util.BCryptPasswordEncoder
import com.bokeh.user.application.user.usecase.UserQueryUseCase
import com.bokeh.user.application.user.vo.UserTokens

@UseCase
class AuthCommandUseCase(
    private val userQueryUseCase: UserQueryUseCase,
) : AuthCommand {

    override fun login(email: String, password: String): UserTokens {
        val user = userQueryUseCase.getUserByEmail(email = email)
        user.checkPasswordMatch(rawPassword = password, matchOperation = BCryptPasswordEncoder::matches)

        //TODO: generate tokens
        val accessToken = ""
        val refreshToken = ""

        return UserTokens(
            accessToken = accessToken,
            refreshToken = refreshToken,
        )
    }

}
