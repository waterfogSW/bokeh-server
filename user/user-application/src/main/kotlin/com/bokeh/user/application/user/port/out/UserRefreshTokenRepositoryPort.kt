package com.bokeh.user.application.user.port.out

import com.bokeh.user.application.user.vo.UserRefreshToken
import java.util.*

interface UserRefreshTokenRepositoryPort {

    fun save(userRefreshToken: UserRefreshToken)

    fun getByUserId(userId: UUID): UserRefreshToken?

}
