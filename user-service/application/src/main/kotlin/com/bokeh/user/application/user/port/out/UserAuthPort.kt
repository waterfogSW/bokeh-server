package com.bokeh.user.application.user.port.out

import com.bokeh.user.application.user.vo.UserToken
import java.util.*

interface UserAuthPort {

    fun saveRefreshToken(userId: UUID, refreshToken: UserToken)

}
