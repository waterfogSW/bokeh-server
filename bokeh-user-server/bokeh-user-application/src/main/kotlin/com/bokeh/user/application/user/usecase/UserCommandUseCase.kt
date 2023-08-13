package com.bokeh.user.application.user.usecase

import com.bokeh.user.application.common.annotation.UseCase
import com.bokeh.user.application.user.util.BCryptPasswordEncoder
import com.bokeh.user.application.user.port.`in`.UserCommand
import com.bokeh.user.application.user.port.out.UserPort
import com.bokeh.user.application.user.vo.CreateUserParam
import com.bokeh.user.domain.user.domain.User

@UseCase
class UserCommandUseCase(
    private val userPort: UserPort,
) : UserCommand {

    override fun createUser(param: CreateUserParam) {
        User.validatePassword(rawPassword = param.password)

        val encodedPassword = BCryptPasswordEncoder.encode(password = param.password)
        val newUser = User(
            username = param.username,
            email = param.email,
            password = encodedPassword,
        )

        userPort.saveUser(user = newUser)
    }


}
