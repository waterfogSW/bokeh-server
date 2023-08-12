package com.bokeh.user.application.port.`in`

import com.bokeh.user.application.vo.CreateUserParam

interface CreateUserCommand {

    fun createUser(param: CreateUserParam)
}
