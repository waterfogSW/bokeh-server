package com.bokeh.user.api.user.controller

import com.bokeh.user.api.user.dto.UserCreateRequest
import com.bokeh.user.api.user.dto.UserInfoResponse
import com.bokeh.user.application.user.usecase.UserCommandUseCase
import com.bokeh.user.application.user.usecase.UserQueryUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/users")
class UserRestController(
    private val userQueryUseCase: UserQueryUseCase,
    private val userCommandUseCase: UserCommandUseCase,
) {

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getUserInfo(@PathVariable id: UUID): UserInfoResponse {
        val userInfo = userQueryUseCase.getUserInfoById(id = id)
        return UserInfoResponse.from(userInfo = userInfo)
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody userCreateRequest: UserCreateRequest) {
        userCommandUseCase.createUser(param = userCreateRequest.toParam())
    }

}
