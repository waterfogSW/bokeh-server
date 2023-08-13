package com.bokeh.user.application.user.usecase

import com.bokeh.user.application.common.annotation.UseCase
import com.bokeh.user.application.user.port.`in`.UserAuthCommand
import com.bokeh.user.application.user.util.BCryptPasswordEncoder
import com.bokeh.user.application.user.vo.UserTokens

@UseCase
class UserAuthCommandUseCase(
    private val userQueryUseCase: UserQueryUseCase,
) : UserAuthCommand {

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
