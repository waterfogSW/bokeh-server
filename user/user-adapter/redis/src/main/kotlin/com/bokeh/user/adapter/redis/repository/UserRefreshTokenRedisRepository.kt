package com.bokeh.user.adapter.redis.repository

import com.bokeh.user.adapter.redis.entity.UserRefreshTokenHash
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRefreshTokenRedisRepository : CrudRepository<UserRefreshTokenHash, String>
