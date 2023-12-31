package com.bokeh.user.api.rest.common.exception

import com.bokeh.user.common.exception.NotFoundException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    private val log = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

    @ExceptionHandler(value = [IllegalArgumentException::class])
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    fun handleBadRequestException(e: Exception): String {
        log.error("Bad Request Exception: ${e.message}")
        return "Bad Request Error: ${e.message}"
    }

    @ExceptionHandler(value = [NotFoundException::class])
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    fun handleNotFoundException(e: NotFoundException): String {
        log.error("Not Found Exception: ${e.message}")
        return "Not Found Error: ${e.message}"
    }

    @ExceptionHandler(value = [RuntimeException::class])
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(e: RuntimeException): String {
        log.debug("Internal Server Error: ${e.message}")
        return "Internal Server Error : ${e.message}"
    }

}
