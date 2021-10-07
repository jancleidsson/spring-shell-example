package com.jss.springshellexample.framework.di

import com.jss.springshellexample.core.repository.UserRepository
import com.jss.springshellexample.core.usecases.AddUser
import com.jss.springshellexample.core.usecases.ExistUser
import com.jss.springshellexample.core.usecases.UpdateUser
import com.jss.springshellexample.framework.usecases.UseCases
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class UserCasesComponent {

    @Autowired
    lateinit var userRepositoryComponent : UserRepositoryComponent

    @Bean
    fun provideUseCases() = UseCases(
        AddUser(userRepositoryComponent.userRepository()),
        UpdateUser(userRepositoryComponent.userRepository()),
        ExistUser(userRepositoryComponent.userRepository())
    )
}