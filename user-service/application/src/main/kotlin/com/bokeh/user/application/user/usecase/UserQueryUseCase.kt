package com.bokeh.user.application.user.usecase

import com.bokeh.user.application.common.annotation.UseCase
import com.bokeh.user.application.user.port.`in`.UserQuery
import com.bokeh.user.application.user.port.out.UserPort
import com.bokeh.user.application.user.vo.UserInfo
import com.bokeh.user.domain.user.domain.User
import java.util.*

@UseCase
class UserQueryUseCase(
    private val userPort: UserPort,
) : UserQuery {
    override fun getUserByEmail(email: String) = userPort.loadUserByEmail(email = email)


    override fun getUserInfoById(id: UUID): UserInfo {
        val findUser = userPort.loadUserById(id = id)
        return UserInfo.from(user = findUser)
    }

    override fun getUserById(id: UUID): User? {
        return userPort.loadUserById(id = id)
    }

}
