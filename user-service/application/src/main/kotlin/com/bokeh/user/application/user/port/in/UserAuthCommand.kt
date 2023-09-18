package com.bokeh.user.application.user.port.`in`

import com.bokeh.user.application.user.vo.UserLoginToken

interface UserAuthCommand {

    fun login(email: String, password: String): UserLoginToken

}
