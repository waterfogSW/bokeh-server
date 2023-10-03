package com.bokeh.user.adapter.persistence.repository

import com.bokeh.user.adapter.persistence.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserJpaRepository : JpaRepository<UserEntity, UUID> {

    fun findByEmail(email: String): Optional<UserEntity>
}
