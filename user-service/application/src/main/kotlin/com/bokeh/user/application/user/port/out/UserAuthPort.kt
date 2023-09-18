package com.bokeh.user.application.user.port.out

import com.bokeh.user.application.user.vo.UserRefreshToken

interface UserAuthPort {

    fun saveRefreshToken(refreshToken: UserRefreshToken)

}
