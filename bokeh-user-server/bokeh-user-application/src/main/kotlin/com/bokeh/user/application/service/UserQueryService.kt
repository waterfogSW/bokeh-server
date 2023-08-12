package com.bokeh.user.application.service

import com.bokeh.user.application.port.`in`.GetUserInfoQuery
import com.bokeh.user.application.port.out.LoadUserPort
import com.bokeh.user.application.vo.UserInfo
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserQueryService(
    private val loadUserPort: LoadUserPort
) : GetUserInfoQuery {

    override fun getUserInfoById(id: UUID): UserInfo {
        val findUser = loadUserPort.loadUserById(id = id)
        return UserInfo.from(user = findUser)
    }

}
