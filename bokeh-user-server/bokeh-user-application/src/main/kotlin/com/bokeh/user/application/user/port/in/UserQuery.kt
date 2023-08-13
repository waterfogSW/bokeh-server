package com.bokeh.user.application.user.port.`in`

import com.bokeh.user.application.user.vo.UserInfo
import java.util.*

interface UserQuery {

    fun getUserInfoById(id: UUID): UserInfo
}
