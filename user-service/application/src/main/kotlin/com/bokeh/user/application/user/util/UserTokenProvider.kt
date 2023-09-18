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

    fun resolveRefreshToken(refreshToken: String): String {
        return JWT.require(algorithm)
            .build()
            .verify(refreshToken)
            .getClaim(USER_ID_KEY)
            .asString()
    }

    fun generateAccessToken(userAuth: UserAuth): UserAuthToken {
        val claims = userAuth.getClaims().toMutableMap()
        claims[TOKEN_TYPE_KEY] = ACCESS_TOKEN_TYPE

        val token = generateToken(
            subject = userAuth.getSubject(),
            claims = claims,
            expiration = jwtProperties.expiration
        )

        return UserAuthToken(
            userId = userAuth.id,
            token = token,
            expiresIn = jwtProperties.expiration,
        )
    }

    fun generateRefreshToken(userAuth: UserAuth): UserAuthToken {
        val claims = mapOf(
            USER_ID_KEY to userAuth.id.toString(),
            TOKEN_TYPE_KEY to REFRESH_TOKEN_TYPE,
        )

        val token = generateToken(
            subject = userAuth.getSubject(),
            claims = claims,
            expiration = jwtProperties.expiration
        )

        return UserAuthToken(
            userId = userAuth.id,
            token = token,
            expiresIn = jwtProperties.expiration,
        )
    }

    private fun generateToken(
        subject: String,
        claims: Map<String, String>,
        expiration: Long,
    ) = JWT.create()
        .withIssuedAt(Date())
        .withExpiresAt(Date(System.currentTimeMillis() + expiration))
        .withSubject(subject)
        .withPayload(claims)
        .sign(algorithm)

}
