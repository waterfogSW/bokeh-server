package com.bokeh.user.application.user.port.out

import java.util.UUID

interface UserAuthPort {

    fun saveRefreshToken(userId: UUID, refreshToken: String)

}
