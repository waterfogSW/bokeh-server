package com.bokeh.user.application.user.port.`in`

import com.bokeh.user.application.user.vo.UserLoginToken
import java.util.*

interface UserAuthCommand {

    fun login(email: String, password: String): UserLoginToken

    fun refreshToken(userId: UUID, refreshTokenString: String): UserLoginToken

}
