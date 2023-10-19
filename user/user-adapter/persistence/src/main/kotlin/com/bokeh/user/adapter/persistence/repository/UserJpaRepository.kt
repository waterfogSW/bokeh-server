package com.bokeh.user.adapter.persistence.repository

import com.bokeh.user.adapter.persistence.entity.UserJPAEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserJpaRepository : JpaRepository<UserJPAEntity, UUID> {

    fun findByEmail(email: String): Optional<UserJPAEntity>
}
