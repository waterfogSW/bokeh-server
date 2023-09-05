package com.bokeh.user.api.user.controller

import com.bokeh.user.api.user.dto.UserAuthLoginRequest
import com.bokeh.user.api.user.dto.UserAuthLoginResponse
import com.bokeh.user.application.user.usecase.UserAuthCommandUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class UserAuthRestController(
    private val userAuthCommandUseCase: UserAuthCommandUseCase,
) {

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    fun login(@RequestBody userAuthLoginRequest: UserAuthLoginRequest) : UserAuthLoginResponse {
        val userTokens = userAuthCommandUseCase.login(
            email = userAuthLoginRequest.email,
            password = userAuthLoginRequest.password,
        )
        return UserAuthLoginResponse.from(userTokens = userTokens)
    }

}
