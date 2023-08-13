package com.bokeh.user.application.port.out

import com.bokeh.user.domain.entity.User
import java.util.UUID

interface LoadUserPort {

    fun loadUserById(id: UUID): User
}
