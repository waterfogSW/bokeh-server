package com.bokeh.user.application.user.port.out

import com.bokeh.user.domain.user.domain.User
import java.util.*

interface UserRepositoryPort {
    fun saveUser(user: User)

    fun loadUserById(id: UUID): User

    fun loadUserByEmail(email: String): User
}
