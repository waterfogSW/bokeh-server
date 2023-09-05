package com.bokeh.user.api.user.dto

import com.bokeh.user.application.user.vo.UserInfo
import com.bokeh.user.domain.user.domain.Role
import java.util.*

data class UserInfoResponse(
    val id: UUID,
    val username: String,
    val email: String,
    val role: Role,
) {
    companion object {
        fun from(userInfo: UserInfo) = UserInfoResponse(
            id = userInfo.id!!,
            username = userInfo.username,
            email = userInfo.email,
            role = userInfo.role,
        )
    }
}
