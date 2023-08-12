package com.bokeh.user.application.port.out

import com.bokeh.user.domain.User
import java.util.UUID

interface LoadUserPort {

    fun loadUserById(id: UUID): User
}
