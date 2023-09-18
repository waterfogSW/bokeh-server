package com.bokeh.user.framework.user.entity

import com.bokeh.user.application.user.vo.UserRefreshToken
import jakarta.persistence.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import java.util.*

@RedisHash("refresh_token")
data class UserRefreshTokenHash(
    @Id
    val id: UUID,
    val token: String,
    @TimeToLive
    val expiredAt: Long,
) {

    companion object {
        private const val MILLIS_IN_SECOND = 1000L
        fun from(userRefreshToken: UserRefreshToken): UserRefreshTokenHash {
            return UserRefreshTokenHash(
                id = userRefreshToken.userId,
                token = userRefreshToken.tokenString,
                expiredAt = userRefreshToken.expiresIn / MILLIS_IN_SECOND
            )
        }
    }
}
