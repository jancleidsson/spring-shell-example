package com.jss.springshellexample.framework.repository

import com.jss.springshellexample.core.model.CliUser
import org.springframework.stereotype.Service

@Service
class MockUserService {
    var currentUsers = arrayListOf<CliUser>()

    fun exists(userName: String?): Boolean {
        if (userName!!.isNotBlank() && currentUsers.find { user -> user.username.equals(userName) } != null) {
            return true
        }
        return false
    }

    fun create(user: CliUser): CliUser {
        user.id = (currentUsers.size + 1).toLong();
        currentUsers.add(user)
        return user
    }

    fun update(user: CliUser): CliUser {
        currentUsers.indexOf(user).let {
            currentUsers.set(it, user)
        }
        return user
    }
}