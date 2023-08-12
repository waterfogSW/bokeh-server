package com.bokeh.user.application.port.out

import com.bokeh.user.domain.User

interface LoadUserPort {

    fun loadUser(username: String): User
}
