package com.bokeh.user.adapter.redis.adapter

import com.bokeh.user.adapter.redis.entity.UserRefreshTokenHash
import com.bokeh.user.adapter.redis.repository.UserRefreshTokenRedisRepository
import com.bokeh.user.application.user.port.out.UserRefreshTokenRepositoryPort
import com.bokeh.user.application.user.vo.UserRefreshToken
import org.springframework.stereotype.Component
import java.util.*


@Component
class UserRefreshTokenRedisAdapter(
    private val userRefreshTokenRedisRepository: UserRefreshTokenRedisRepository,
) : UserRefreshTokenRepositoryPort {

    override fun save(userRefreshToken: UserRefreshToken) {
        val userRefreshTokenHash = UserRefreshTokenHash.from(userRefreshToken = userRefreshToken)
        userRefreshTokenRedisRepository.save(userRefreshTokenHash)
    }

    override fun getByUserId(userId: UUID): UserRefreshToken? {
        val userRefreshTokenHash: UserRefreshTokenHash? = userRefreshTokenRedisRepository
            .findById(userId.toString())
            .orElse(null)
        return userRefreshTokenHash?.toUserRefreshToken()
    }

}
