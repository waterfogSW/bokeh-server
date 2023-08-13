package com.bokeh.user.framework.user.adapter

import com.bokeh.user.application.user.port.out.UserPort
import com.bokeh.user.domain.user.entity.User
import com.bokeh.user.framework.common.annotation.PersistenceAdapter
import com.bokeh.user.framework.common.exception.NotFoundException
import com.bokeh.user.framework.user.mapper.UserEntityMapper
import java.util.*

@PersistenceAdapter
class UserPersistenceAdapter(
    private val userJpaRepository: UserRepository,
    private val userEntityMapper: UserEntityMapper,
) : UserPort {

    override fun loadUserById(id: UUID): User {
        return userJpaRepository.findById(id)
            .orElseThrow { throw NotFoundException("User with id $id not found") }
            .let { userEntityMapper.toDomain(it) }
    }

    override fun saveUser(user: User) {
        val entity = userEntityMapper.toEntity(user)
        userJpaRepository.save(entity)
    }

}
