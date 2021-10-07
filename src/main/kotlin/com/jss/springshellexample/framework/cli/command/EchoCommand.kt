package com.jss.springshellexample.framework.cli.command

import com.jss.springshellexample.framework.cli.helper.ShellHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import org.springframework.shell.standard.ShellOption

@ShellComponent
class EchoCommand {

    @Autowired
    lateinit var shellHelper: ShellHelper

    @ShellMethod("Displays greeting message to the user whose name is supplied")
    fun echo(@ShellOption("-N", "--name") name: String?): String? {
        val message = "Hello $name"
        shellHelper.print("$message (Default style message)")
        shellHelper.printError("$message (Error style message)")
        shellHelper.printWarning("$message (Warning style message)")
        shellHelper.printInfo("$message (Info style message)")
        shellHelper.printSuccess("$message (Success style message)")
        shellHelper.print("$message (Custom style message)")

        val output = shellHelper.getSuccessMessage(message)
        return "$output You are running spring shell cli-demo."
    }
}