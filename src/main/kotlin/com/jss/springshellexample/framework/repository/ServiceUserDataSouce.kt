package com.jss.springshellexample.framework.repository

import com.jss.springshellexample.core.model.CliUser
import com.jss.springshellexample.core.repository.UserDataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ServiceUserDataSource: UserDataSource {

    @Autowired
    lateinit var userService: MockUserService

    override fun exists(username: String?) = userService.exists(username)
    override fun create(user: CliUser) = userService.create(user)
    override fun update(user: CliUser) = userService.update(user)
}