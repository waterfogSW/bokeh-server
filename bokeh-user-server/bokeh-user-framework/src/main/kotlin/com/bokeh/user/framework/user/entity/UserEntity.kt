package com.bokeh.user.framework.user.entity

import com.bokeh.user.domain.user.entity.Role
import com.bokeh.user.framework.common.entity.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "`user`")
class UserEntity(
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
