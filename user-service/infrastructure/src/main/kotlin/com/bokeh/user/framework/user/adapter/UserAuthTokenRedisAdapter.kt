package com.bokeh.user.framework.user.adapter

import com.bokeh.user.application.user.port.out.UserAuthPort
import com.bokeh.user.application.user.vo.UserRefreshToken
import com.bokeh.user.framework.common.annotation.Adapter
import com.bokeh.user.framework.user.entity.UserRefreshTokenHash

@Adapter
class UserAuthTokenRedisAdapter(
    private val userAuthTokenRedisRepository: UserAuthTokenRedisRepository,
) : UserAuthPort {

    override fun saveRefreshToken(userRefreshToken: UserRefreshToken) {
        val userRefreshTokenHash = UserRefreshTokenHash.from(userRefreshToken = userRefreshToken)
        userAuthTokenRedisRepository.save(userRefreshTokenHash)
    }


}
