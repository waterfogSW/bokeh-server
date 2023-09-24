package com.bokeh.user.framework.user.adapter

import com.bokeh.user.application.user.port.out.UserRefreshTokenPort
import com.bokeh.user.application.user.vo.UserRefreshToken
import com.bokeh.user.framework.common.annotation.Adapter
import com.bokeh.user.framework.user.entity.UserRefreshTokenHash
import java.util.*

@Adapter
class UserRefreshTokenRedisAdapter(
    private val userAuthTokenRedisRepository: UserAuthTokenRedisRepository,
) : UserRefreshTokenPort {

    override fun saveRefreshToken(userRefreshToken: UserRefreshToken) {
        val userRefreshTokenHash = UserRefreshTokenHash.from(userRefreshToken = userRefreshToken)
        userAuthTokenRedisRepository.save(userRefreshTokenHash)
    }

    override fun getRefreshTokenByUserId(userId: UUID): UserRefreshToken? {
        val userRefreshTokenHash: UserRefreshTokenHash? = userAuthTokenRedisRepository
            .findById(userId.toString())
            .orElse(null)
        return userRefreshTokenHash?.toUserRefreshToken()
    }

}
