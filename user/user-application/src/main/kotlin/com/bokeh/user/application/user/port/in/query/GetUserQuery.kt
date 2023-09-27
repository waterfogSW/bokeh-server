package com.bokeh.user.application.user.port.`in`.query

import com.bokeh.user.application.user.port.out.UserRepositoryPort
import com.bokeh.user.domain.user.domain.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class GetUserQuery(
    private val userRepositoryPort: UserRepositoryPort,
) : GetUserQueryUseCase {
    override fun getById(id: UUID): User {
        return userRepositoryPort.loadUserById(id = id)
    }

    override fun getByEmail(email: String): User {
        return userRepositoryPort.loadUserByEmail(email = email)
    }
}
