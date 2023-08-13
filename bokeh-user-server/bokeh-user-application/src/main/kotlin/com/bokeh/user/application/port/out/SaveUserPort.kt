package com.bokeh.user.application.port.out

import com.bokeh.user.domain.entity.User

interface SaveUserPort {

    fun saveUser(user: User)
}
