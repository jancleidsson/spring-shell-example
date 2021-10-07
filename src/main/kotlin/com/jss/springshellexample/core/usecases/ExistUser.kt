package com.jss.springshellexample.core.usecases

import com.jss.springshellexample.core.repository.UserRepository

class ExistUser (private val userRepository: UserRepository) {
    operator fun invoke(userName: String?) = userRepository.exist(userName)
}