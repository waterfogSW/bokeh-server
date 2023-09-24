package com.bokeh.user.framework.user.adapter

import com.bokeh.user.framework.user.entity.UserRefreshTokenHash
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface UserAuthTokenRedisRepository : CrudRepository<UserRefreshTokenHash, String>
