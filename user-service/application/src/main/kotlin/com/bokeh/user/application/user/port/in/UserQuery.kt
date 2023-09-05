package com.bokeh.user.application.user.port.`in`

import com.bokeh.user.application.user.vo.UserInfo
import com.bokeh.user.domain.user.domain.User
import java.util.*

interface UserQuery {

    fun getUserByEmail(email: String): User

    fun getUserInfoById(id: UUID): UserInfo
}
