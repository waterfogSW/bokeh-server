package com.bokeh.user.domain.user.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import java.util.*

class UserTest : DescribeSpec({
    describe("사용자 생성") {
        context("username의 길이가 3-10 사이일 때") {
            it("생성된다") {
                shouldNotThrowAny {
                    User(
                        username = "user01",
                        password = "password",
                        email = "user01@example.com"
                    )
                }
            }
        }

        context("username의 길이가 3보다 작을 때") {
            it("IllegalArgumentException이 발생한다") {
                shouldThrow<IllegalArgumentException> {
                    User(username = "us", password = "password", email = "us@example.com")
                }
            }
        }

        context("username의 길이가 10을 초과할 때") {
            it("IllegalArgumentException이 발생한다") {
                shouldThrow<IllegalArgumentException> {
                    User(
                        username = "longusername",
                        password = "password",
                        email = "longusername@example.com"
                    )
                }
            }
        }

        context("email 형식이 잘못되었을 때") {
            it("IllegalArgumentException이 발생한다") {
                shouldThrow<IllegalArgumentException> {
                    User(username = "user01", password = "password", email = "wrongemail")
                }
            }
        }
    }

    describe("비밀번호 검증") {

        context("'password'입력값과 저장된 'password'가 일치하면") {
            val savedPassword = "password"
            val inputPassword = "password"

            it("에러가 발생하지 않는다") {
                val user = User(
                    username = "user01",
                    password = savedPassword,
                    email = "user01@exmaple.com"
                )

                shouldNotThrowAny {
                    user.checkPasswordMatch(inputPassword) { raw, hashed -> raw == hashed }
                }
            }

        }
        context("'password' 입력값과 저장된 'password' 가 일치하지 않으면 ") {
            val savedPassword = "password"
            val inputPassword = "wrongpassword"

            it("에러가 발생한다") {

                val user = User(
                    username = "user01",
                    password = savedPassword,
                    email = "user01@example.com"
                )

                shouldThrow<IllegalArgumentException> {
                    user.checkPasswordMatch(inputPassword) { raw, hashed -> raw == hashed }
                }
            }
        }
    }
})
