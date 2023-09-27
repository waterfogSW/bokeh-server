package com.bokeh.user.api.user.controller

import com.bokeh.user.api.user.dto.UserLoginRequest
import com.bokeh.user.api.user.dto.UserCreateRequest
import com.bokeh.user.api.user.dto.UserLoginResponse
import com.bokeh.user.application.user.port.`in`.command.UserCreateCommand
import com.bokeh.user.application.user.port.`in`.command.UserCreateCommandUseCase
import com.bokeh.user.application.user.port.`in`.command.UserLoginCommand
import com.bokeh.user.application.user.port.`in`.command.UserLoginCommandUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class UserRestController(
    private val userCreateCommand: UserCreateCommand,
    private val userLoginCommand: UserLoginCommand,
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

        userCreateCommand.create(command = command)
    }

    @PostMapping("login")
    @ResponseStatus(HttpStatus.OK)
    fun login(@RequestBody userLoginRequest: UserLoginRequest): UserLoginResponse {
        val command: UserLoginCommandUseCase.Command =
            UserLoginCommandUseCase.Command(
                email = userLoginRequest.email,
                password = userLoginRequest.password,
            )

        return userLoginCommand
            .login(command = command)
            .let { UserLoginResponse.from(result = it) }
    }

}
