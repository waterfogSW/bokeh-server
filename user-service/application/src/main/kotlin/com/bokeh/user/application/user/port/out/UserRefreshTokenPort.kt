package com.bokeh.user.application.user.port.out

import com.bokeh.user.application.user.vo.UserRefreshToken
import java.util.*

interface UserRefreshTokenPort {

    fun saveRefreshToken(userRefreshToken: UserRefreshToken)

    fun getRefreshTokenByUserId(userId: UUID): UserRefreshToken?

}
