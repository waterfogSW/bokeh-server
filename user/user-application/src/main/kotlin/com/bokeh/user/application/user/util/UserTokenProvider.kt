package com.bokeh.user.application.user.util

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.bokeh.user.application.common.properties.JwtProperties
import com.bokeh.user.application.user.vo.UserAccessToken
import com.bokeh.user.domain.user.domain.UserAuth
import com.bokeh.user.application.user.vo.UserRefreshToken
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserTokenProvider(
    private val jwtProperties: JwtProperties,
) {

    private val algorithm = Algorithm.HMAC256(jwtProperties.secret)

    fun generateAccessToken(userAuth: UserAuth): UserAccessToken {
        val tokenString: String = generateTokenString(
            subject = userAuth.getSubject(),
            claims = userAuth.getClaims(),
            expiration = jwtProperties.expiration,
        )

        return UserAccessToken(
            userId = userAuth.id,
            tokenString = tokenString,
            expiresIn = jwtProperties.expiration,
        )
    }

    fun generateRefreshToken(userAuth: UserAuth): UserRefreshToken {
        val tokenString: String = generateTokenString(
            subject = userAuth.getSubject(),
            expiration = jwtProperties.refreshExpiration,
        )
        return UserRefreshToken(
            userId = userAuth.id,
            tokenString = tokenString,
            expiresIn = jwtProperties.refreshExpiration,
        )
    }

    private fun generateTokenString(
        subject: String,
        claims: Map<String, String> = emptyMap(),
        expiration: Long,
    ): String = JWT.create()
        .withIssuedAt(Date())
        .withExpiresAt(Date(System.currentTimeMillis() + expiration))
        .withSubject(subject)
        .withPayload(claims)
        .sign(algorithm)

}
