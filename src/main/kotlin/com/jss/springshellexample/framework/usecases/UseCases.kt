package com.jss.springshellexample.framework.usecases

import com.jss.springshellexample.core.usecases.AddUser
import com.jss.springshellexample.core.usecases.ExistUser
import com.jss.springshellexample.core.usecases.UpdateUser

class UseCases(
    val addUser: AddUser,
    val updateUser: UpdateUser,
    val existUser: ExistUser
)