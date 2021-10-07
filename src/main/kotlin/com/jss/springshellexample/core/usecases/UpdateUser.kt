package com.jss.springshellexample.core.usecases

import com.jss.springshellexample.core.model.CliUser
import com.jss.springshellexample.core.repository.UserRepository

class UpdateUser(private val userRepository: UserRepository) {
    operator fun invoke(cliUser: CliUser) = userRepository.update(cliUser)
}