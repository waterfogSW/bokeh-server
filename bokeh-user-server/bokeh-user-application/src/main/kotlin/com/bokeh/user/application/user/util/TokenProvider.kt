package com.bokeh.user.application.user.util

import com.bokeh.user.application.common.properties.JwtProperties
import com.bokeh.user.application.user.vo.UserAuth
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.*

@Component
class TokenProvider(
    private val jwtProperties: JwtProperties,
) {

    private val algorithm = SignatureAlgorithm.HS512

    fun generateAccessToken(
        userAuth: UserAuth,
        expiration: Long = jwtProperties.expiration,
    ): String {
        val claims = userAuth.toClaims().toMutableMap()
        claims["token_type"] = "access"
        return generateToken(claims, expiration)
    }

    fun generateRefreshToken(
        userAuth: UserAuth,
        expiration: Long = jwtProperties.refreshExpiration,
    ): String {
        val claims = mapOf(
            "id" to userAuth.id.toString(),
            "token_type" to "refresh",
        )
        return generateToken(claims, expiration)
    }

    private fun generateToken(
        claims: Map<String, Any>,
        expiration: Long,
    ): String {
        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + expiration))
            .signWith(algorithm, jwtProperties.secret)
            .compact()
    }

}
