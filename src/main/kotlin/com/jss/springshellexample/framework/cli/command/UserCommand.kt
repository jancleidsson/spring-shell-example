package com.jss.springshellexample.framework.cli.command

import com.jss.springshellexample.core.model.CliUser
import com.jss.springshellexample.framework.cli.helper.InputReader
import com.jss.springshellexample.framework.cli.helper.ShellHelper
import com.jss.springshellexample.framework.usecases.UseCases
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import org.springframework.shell.standard.ShellOption


@ShellComponent
class UserCommand {

    @Autowired
    lateinit var useCases: UseCases

    @Autowired
    lateinit var shellHelper: ShellHelper

    @Autowired
    lateinit var inputReader: InputReader

    @ShellMethod("Create new user with supplied username")
    fun createUser(@ShellOption("-U", "--username") username: String?) {
        if (useCases.existUser(username)) {
            shellHelper.printError(String.format("User with username='%s' already exists --> ABORTING", username))
            return
        } else {
            val user = CliUser(1)
            do {
                val fullName = inputReader.prompt("Full name")
                if (!fullName.isNullOrEmpty()) {
                    user.fullName = fullName
                } else {
                    shellHelper.printWarning("User's full name CAN NOT be empty string? Please enter valid value!")
                }
            } while (user.fullName.isNullOrEmpty())

            do {
                val password = inputReader.prompt("Password", "secret", false)
                if (!password.isNullOrEmpty()) {
                    user.password = password
                } else {
                    shellHelper.printWarning("Password'CAN NOT be empty string? Please enter valid value!")
                }
            } while (user.password.isNullOrEmpty())

            shellHelper.printInfo("\nCreating new user:")
            shellHelper.print(
                """
           
                Username: ${user.username}
                """.trimIndent()
            )
            shellHelper.print("Password: " + user.password)
            shellHelper.print("Full Name: " + user.fullName)
            shellHelper.print("Gender: " + user.gender)
            shellHelper.print(
                """
                Superuser: ${user.superuser.toString()}
                
                """.trimIndent()
            )

            val createdUser = useCases.addUser(user)
            shellHelper.printSuccess("Created user with id=" + createdUser.id)
        }
    }
}