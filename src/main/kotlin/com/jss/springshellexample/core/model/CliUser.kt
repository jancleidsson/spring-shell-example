package com.jss.springshellexample.core.model

data class CliUser(
    var id: Long,
    var username: String? = "",
    var password: String? = "",
    var fullName: String? = "",
    var gender: Gender? = Gender.MALE,
    var superuser: Boolean? = false
)
