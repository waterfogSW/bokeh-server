package com.bokeh.user.application.service

import com.bokeh.user.application.port.`in`.CreateUserCommand
import com.bokeh.user.application.port.out.SaveUserPort
import com.bokeh.user.application.vo.CreateUserParam
import com.bokeh.user.domain.User
import org.springframework.stereotype.Service

@Service
class UserCommandService(
    private val saveUserPort: SaveUserPort,
) : CreateUserCommand {

    override fun createUser(param: CreateUserParam) {
        val newUser = User(
            username = param.username,
            email = param.email,
            password = param.password,
        )

        saveUserPort.saveUser(user = newUser)
    }


}
