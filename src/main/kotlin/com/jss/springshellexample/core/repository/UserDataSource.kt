package com.jss.springshellexample.core.repository

import com.jss.springshellexample.core.model.CliUser

interface UserDataSource {
    fun exists(username: String?): Boolean
    fun create(user: CliUser): CliUser
    fun update(user: CliUser): CliUser
}