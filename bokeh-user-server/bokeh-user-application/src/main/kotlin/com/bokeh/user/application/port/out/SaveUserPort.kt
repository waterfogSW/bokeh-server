package com.bokeh.user.application.port.out

import com.bokeh.user.domain.User

interface SaveUserPort {

    fun saveUser(user: User)
}
