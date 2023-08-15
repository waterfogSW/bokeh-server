package com.bokeh.user.framework.user.adapter

import com.bokeh.user.application.user.port.out.UserAuthPort
import com.bokeh.user.application.user.vo.UserAuthToken
import com.bokeh.user.framework.common.annotation.Adapter
import java.util.*

@Adapter
class UserAuthRedisAdapter: UserAuthPort {

    override fun saveRefreshToken(userId: UUID, refreshToken: UserAuthToken) {
        //TODO: Implement
    }


}
