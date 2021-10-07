package com.jss.springshellexample.core.repository

import com.jss.springshellexample.core.model.CliUser

class UserRepository(private val userDataSource: UserDataSource) {
    fun add(cliUser: CliUser) = userDataSource.create(cliUser)
    fun update(cliUser: CliUser) = userDataSource.update(cliUser)
    fun exist(userName: String?) = userDataSource.exists(userName)
}