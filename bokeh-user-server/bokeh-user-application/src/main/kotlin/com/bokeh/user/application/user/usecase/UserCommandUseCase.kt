package com.bokeh.user.application.user.usecase

import com.bokeh.user.application.user.port.`in`.UserCommand
import com.bokeh.user.application.user.port.out.UserPort
import com.bokeh.user.application.user.vo.CreateUserParam
import com.bokeh.user.domain.user.entity.User
import org.springframework.stereotype.Component

@Component
class UserCommandUseCase(
    private val userPort: UserPort,
) : UserCommand {

    override fun createUser(param: CreateUserParam) {
        val newUser = User(
            username = param.username,
            email = param.email,
            password = param.password,
        )

        userPort.saveUser(user = newUser)
    }


}
