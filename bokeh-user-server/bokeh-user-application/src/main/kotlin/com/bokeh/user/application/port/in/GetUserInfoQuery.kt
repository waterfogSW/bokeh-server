package com.bokeh.user.application.port.`in`

import com.bokeh.user.application.vo.UserInfo
import java.util.*

interface GetUserInfoQuery {

    fun getUserInfoById(id: UUID): UserInfo
}
