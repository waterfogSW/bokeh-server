package com.bokeh.user.application.user.port.`in`.command

import com.bokeh.user.application.user.port.out.UserRepositoryPort
import com.bokeh.user.application.user.util.BCryptPasswordEncoder
import com.bokeh.user.domain.user.domain.User
import org.springframework.stereotype.Service

@Service
class UserCreateCommand(
    private val userRepositoryPort: UserRepositoryPort,
) : UserCreateCommandUseCase {
    override fun create(command: UserCreateCommandUseCase.Command) {
        User.validatePassword(rawPassword = command.password)

        val encodedPassword = BCryptPasswordEncoder.encode(password = command.password)
        val newUser = User(
            username = command.username,
            email = command.email,
            password = encodedPassword,
        )

        userRepositoryPort.saveUser(user = newUser)
    }
}
