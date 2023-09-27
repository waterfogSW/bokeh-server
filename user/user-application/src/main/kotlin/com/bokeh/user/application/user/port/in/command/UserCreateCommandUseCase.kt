package com.bokeh.user.application.user.port.`in`.command

interface UserCreateCommandUseCase {

    fun create(command: Command)
    data class Command(
        val username: String,
        val password: String,
        val email: String,
    )
}
