package com.bokeh.user.application.user.usecase

import com.bokeh.user.application.user.port.out.UserAuthPort
import com.bokeh.user.application.user.util.BCryptPasswordEncoder
import com.bokeh.user.application.user.util.UserTokenProvider
import com.bokeh.user.application.user.vo.UserAccessToken
import com.bokeh.user.application.user.vo.UserLoginToken
import com.bokeh.user.application.user.vo.UserRefreshToken
import com.bokeh.user.domain.user.domain.User
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import org.junit.jupiter.api.DisplayName
import org.springframework.test.util.ReflectionTestUtils
import java.util.*


@DisplayName("User 인증 커맨드")
class UserAuthCommandUseCaseTest : DescribeSpec({

    val userQueryUseCase = mockk<UserQueryUseCase>()
    val userTokenProvider = mockk<UserTokenProvider>()
    val userAuthPort = mockk<UserAuthPort>()
    val userAuthCommandUseCase = UserAuthCommandUseCase(
        userQueryUseCase = userQueryUseCase,
        userTokenProvider = userTokenProvider,
        userAuthPort = userAuthPort,
    )

    describe("로그인") {
        val userId = UUID.randomUUID()
        val username = "test1234"
        val email = "test1234@gmail.com"
        val password = "test1234"
        val user: User = User(
            username = username,
            email = email,
            password = BCryptPasswordEncoder.encode(password),
        )
        ReflectionTestUtils.setField(user, "id", userId)
        every { userQueryUseCase.getUserByEmail(email) } returns user

        context("만약 패스워드가 일치하면") {

            val inputPassword = "test1234"

            it("로그인 토큰을 반환한다") {
                val userAccessToken = UserAccessToken(userId, "accessTokenString", 10L)
                val userRefreshToken = UserRefreshToken(userId, "refreshTokenString", 20L)

                every { userTokenProvider.generateAccessToken(any()) } returns userAccessToken
                every { userTokenProvider.generateRefreshToken(any()) } returns userRefreshToken
                every { userAuthPort.saveRefreshToken(any()) } just Runs

                val userLoginToken: UserLoginToken = userAuthCommandUseCase.login(email, inputPassword)
                userLoginToken.shouldBe(UserLoginToken(userAccessToken, userRefreshToken))
            }

        }

        context("만약 패스워드가 일치하지 않으면") {

            val inputPassword = "test12345"

            it("예외를 던진다") {
                shouldThrow<IllegalArgumentException> { userAuthCommandUseCase.login(email, inputPassword) }
            }
        }
    }

})
