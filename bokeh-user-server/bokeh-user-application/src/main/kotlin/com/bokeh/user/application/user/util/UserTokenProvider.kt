package com.bokeh.user.application.user.util

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.bokeh.user.application.common.properties.JwtProperties
import com.bokeh.user.application.user.vo.UserAuth
import com.bokeh.user.application.user.vo.UserAuthToken
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserTokenProvider(
    private val jwtProperties: JwtProperties,
) {

    private val algorithm = Algorithm.HMAC256(jwtProperties.secret)

    companion object {
        private const val TOKEN_TYPE_KEY = "token_type"
        private const val ACCESS_TOKEN_TYPE = "access"
        private const val REFRESH_TOKEN_TYPE = "refresh"
        private const val USER_ID_KEY = "id"
    }


    fun generateAccessToken(userAuth: UserAuth): UserAuthToken {
        val claims = userAuth.toClaims().toMutableMap()
        claims[TOKEN_TYPE_KEY] = ACCESS_TOKEN_TYPE
        return generateToken(claims, jwtProperties.expiration)
    }

    fun generateRefreshToken(userAuth: UserAuth): UserAuthToken {
        val claims = mapOf(
            USER_ID_KEY to userAuth.id.toString(),
            TOKEN_TYPE_KEY to REFRESH_TOKEN_TYPE,
        )
        return generateToken(claims, jwtProperties.refreshExpiration)
    }

    private fun generateToken(
        claims: Map<String, String>,
        expiration: Long,
    ): UserAuthToken {
        val token = JWT.create()
            .withIssuedAt(Date())
            .withExpiresAt(Date(System.currentTimeMillis() + expiration))
            .withSubject(claims[USER_ID_KEY].toString())
            .withPayload(claims)
            .sign(algorithm)

        return UserAuthToken(
            token = token,
            expiresIn = expiration,
        )
    }

}
