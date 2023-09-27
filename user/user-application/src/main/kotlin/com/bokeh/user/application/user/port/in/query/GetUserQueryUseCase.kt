package com.bokeh.user.application.user.port.`in`.query

import com.bokeh.user.domain.user.domain.User
import java.util.*

interface GetUserQueryUseCase {

    fun getById(id: UUID): User
    fun getByEmail(email: String): User
}
