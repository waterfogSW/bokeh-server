package com.bokeh.user.application.auth.port.`in`

import com.bokeh.user.application.user.vo.UserTokens

interface AuthCommand {

    fun login(email: String, password: String): UserTokens

}
