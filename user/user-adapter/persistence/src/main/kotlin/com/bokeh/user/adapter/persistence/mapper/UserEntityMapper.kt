package com.bokeh.user.adapter.persistence.mapper

import com.bokeh.user.adapter.persistence.entity.UserEntity
import com.bokeh.user.domain.user.domain.User
import org.springframework.stereotype.Component

@Component
class UserEntityMapper {

    fun toEntity(user: User) = UserEntity(
        username = user.username,
        email = user.email,
        password = user.password,
        role = user.role,
    )

    fun toDomain(entity: UserEntity) = User(
        id = entity.id,
        username = entity.username,
        email = entity.email,
        password = entity.password,
        role = entity.role,
    )

}
