package com.bokeh.user.application.user.port.`in`

import com.bokeh.user.application.user.vo.UserTokens

interface UserAuthCommand {

    fun login(email: String, password: String): UserTokens

}
