package com.jss.springshellexample.framework.di

import com.jss.springshellexample.core.repository.UserDataSource
import com.jss.springshellexample.core.repository.UserRepository
import com.jss.springshellexample.framework.repository.ServiceUserDataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class UserRepositoryComponent {

    @Autowired
    lateinit var serviceUserDataSource: ServiceUserDataSource

    @Bean
    fun userRepository() = UserRepository(serviceUserDataSource)
}