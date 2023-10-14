package com.bokeh.user.api.rest.controller

import com.bokeh.user.api.rest.dto.UserCreateRequest
import com.bokeh.user.api.rest.dto.UserLoginRequest
import com.bokeh.user.api.rest.dto.UserLoginResponse
import com.bokeh.user.api.rest.dto.UserLogoutRequest
import com.bokeh.user.application.user.port.`in`.command.UserCreateCommandUseCase
import com.bokeh.user.application.user.port.`in`.command.UserLoginCommandUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("user")
class UserRestController(
    private val userCreateCommandUseCase: UserCreateCommandUseCase,
    private val userLoginCommandUseCase: UserLoginCommandUseCase,
) {

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody userCreateRequest: UserCreateRequest) {
        val command: UserCreateCommandUseCase.Command =
            UserCreateCommandUseCase.Command(
                username = userCreateRequest.username,
                password = userCreateRequest.password,
                email = userCreateRequest.email,
            )

        userCreateCommandUseCase.create(command = command)
    }

    @PostMapping("login")
    @ResponseStatus(HttpStatus.OK)
    fun login(@RequestBody userLoginRequest: UserLoginRequest): UserLoginResponse {
        val command: UserLoginCommandUseCase.Command =
            UserLoginCommandUseCase.Command(
                email = userLoginRequest.email,
                password = userLoginRequest.password,
            )

        return userLoginCommandUseCase
            .login(command = command)
            .let { UserLoginResponse.from(result = it) }
    }

    @PostMapping("logout")
    @ResponseStatus(HttpStatus.OK)
    fun logout(@RequestBody userLogoutRequest: UserLogoutRequest) {
        //TODO: Implement logout use case
    }

}
