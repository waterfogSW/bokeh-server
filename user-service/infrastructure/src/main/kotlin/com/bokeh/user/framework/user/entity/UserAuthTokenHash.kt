package com.bokeh.user.framework.user.entity

import com.bokeh.user.application.user.vo.UserToken
import jakarta.persistence.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import java.util.*

@RedisHash("refresh_token")
data class UserAuthTokenHash(
    @Id
    val id: UUID,
    val token: String,
    @TimeToLive
    val expiredAt: Long,
) {

    companion object {
        private const val MILLIS_IN_SECOND = 1000L
        fun from(userToken: UserToken): UserAuthTokenHash {
            return UserAuthTokenHash(
                id = userToken.userId,
                token = userToken.token,
                expiredAt = userToken.expiresIn / MILLIS_IN_SECOND
            )
        }
    }
}
