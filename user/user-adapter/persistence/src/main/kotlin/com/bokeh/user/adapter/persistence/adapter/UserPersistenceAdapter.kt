package com.bokeh.user.adapter.persistence.adapter

import com.bokeh.user.adapter.persistence.mapper.UserEntityMapper
import com.bokeh.user.adapter.persistence.repository.UserJpaRepository
import com.bokeh.user.application.user.port.out.UserRepositoryPort
import com.bokeh.user.common.exception.NotFoundException
import com.bokeh.user.domain.user.domain.User
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserPersistenceAdapter(
    private val userJpaRepository: UserJpaRepository,
    private val userEntityMapper: UserEntityMapper,
) : UserRepositoryPort {

    override fun loadUserById(id: UUID): User {
        return userJpaRepository.findById(id)
            .orElseThrow { throw NotFoundException("User with id $id not found") }
            .let { userEntityMapper.toDomain(it) }
    }

    override fun loadUserByEmail(email: String): User {
        return userJpaRepository.findByEmail(email)
            .orElseThrow { throw NotFoundException("User with email $email not found") }
            .let { userEntityMapper.toDomain(it) }
    }

    override fun saveUser(user: User) {
        val entity = userEntityMapper.toEntity(user)
        userJpaRepository.save(entity)
    }

}
