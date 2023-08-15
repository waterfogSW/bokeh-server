package com.bokeh.user.application.user.port.out

import com.bokeh.user.application.user.vo.UserAuthToken
import java.util.*

interface UserAuthPort {

    fun saveRefreshToken(userId: UUID, refreshToken: UserAuthToken)

}
