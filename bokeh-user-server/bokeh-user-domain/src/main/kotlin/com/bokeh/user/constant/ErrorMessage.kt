package com.bokeh.user.constant

enum class ErrorMessage(
    val msg: String
) {
    INVALID_USERNAME_SET("Username should be between 3 and 10 characters and not blank."),
    INVALID_PASSWORD_SET("Password should be between 8 adn 20 characters and not blank."),
    INVALID_EMAIL_SET("Email should be valid and not blank."),
}
