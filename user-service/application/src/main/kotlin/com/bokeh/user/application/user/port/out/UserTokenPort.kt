package com.bokeh.user.application.user.port.out

import com.bokeh.user.application.user.vo.UserRefreshToken

interface UserTokenPort {

    fun saveRefreshToken(userRefreshToken: UserRefreshToken)

}
