package com.bokeh.user.adapter.persistence.mapper

import com.bokeh.user.adapter.persistence.entity.UserJPAEntity
import com.bokeh.user.domain.user.domain.User
import org.springframework.stereotype.Component

@Component
class UserEntityMapper {

    fun toEntity(user: User) = UserJPAEntity(
        username = user.username,
        email = user.email,
        password = user.password,
        role = user.role,
    )

    fun toDomain(entity: UserJPAEntity) = User(
        id = entity.id,
        username = entity.username,
        email = entity.email,
        password = entity.password,
        role = entity.role,
    )

}
