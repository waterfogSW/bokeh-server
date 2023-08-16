package com.bokeh.user.framework.user.adapter

import com.bokeh.user.application.user.port.out.UserAuthPort
import com.bokeh.user.application.user.vo.UserAuthToken
import com.bokeh.user.framework.common.annotation.Adapter
import com.bokeh.user.framework.user.entity.UserAuthTokenHash
import java.util.*

@Adapter
class UserAuthTokenRedisAdapter(
    private val userAuthTokenRedisRepository: UserAuthTokenRedisRepository,
) : UserAuthPort {

    override fun saveRefreshToken(userId: UUID, refreshToken: UserAuthToken) {
        val userAuthTokenHash = UserAuthTokenHash.from(userToken = refreshToken)
        userAuthTokenRedisRepository.save(userAuthTokenHash)
    }


}
