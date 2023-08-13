package com.bokeh.user.application.user.port.out

import com.bokeh.user.domain.user.entity.User
import java.util.*

interface UserPort {
    fun saveUser(user: User)

    fun loadUserById(id: UUID): User
}
