package com.bokeh.user.adapter.persistence.entity

import com.bokeh.user.adapter.persistence.common.entity.BaseEntity
import com.bokeh.user.domain.user.domain.Role
import jakarta.persistence.*

@Entity
@Table(name = "`user`")
class UserJPAEntity(
    username: String,
    password: String,
    email: String,
    role: Role,
) : BaseEntity() {

    @Column(nullable = false, unique = true)
    var username: String = username
        private set

    @Column(nullable = false)
    var password: String = password
        private set

    @Column(nullable = false, unique = true)
    var email: String = email
        private set

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var role: Role = role
        private set

}
