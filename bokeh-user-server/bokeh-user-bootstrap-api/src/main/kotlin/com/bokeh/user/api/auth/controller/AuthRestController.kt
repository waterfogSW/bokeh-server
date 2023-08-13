package com.bokeh.user.api.auth.controller

import com.bokeh.user.api.auth.dto.AuthLoginRequest
import com.bokeh.user.api.auth.dto.AuthLoginResponse
import com.bokeh.user.application.auth.usecase.AuthCommandUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthRestController(
    private val authCommandUseCase: AuthCommandUseCase,
) {

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    fun login(@RequestBody authLoginRequest: AuthLoginRequest) : AuthLoginResponse {
        val userTokens = authCommandUseCase.login(
            email = authLoginRequest.email,
            password = authLoginRequest.password,
        )
        return AuthLoginResponse.from(userTokens = userTokens)
    }

}
