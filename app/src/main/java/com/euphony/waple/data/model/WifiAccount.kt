package com.euphony.waple.data.model

data class WifiAccount(
    val name: String,
    val password: String
) {
    init {
        check(name.isNotBlank())
        check(password.isNotBlank())
    }
}