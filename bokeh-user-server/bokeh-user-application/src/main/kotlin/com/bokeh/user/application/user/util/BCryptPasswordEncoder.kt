package com.bokeh.user.application.user.util

import org.mindrot.jbcrypt.BCrypt

object BCryptPasswordEncoder {

    fun encode(password: String): String {
        return BCrypt.hashpw(password, BCrypt.gensalt())
    }

    fun matches(password: String, hashedPassword: String): Boolean {
        return BCrypt.checkpw(password, hashedPassword)
    }
}
