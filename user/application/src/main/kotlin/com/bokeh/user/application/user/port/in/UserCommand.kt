package com.bokeh.user.application.user.port.`in`

import com.bokeh.user.application.user.vo.CreateUserParam

interface UserCommand {

    fun createUser(param: CreateUserParam)
}
