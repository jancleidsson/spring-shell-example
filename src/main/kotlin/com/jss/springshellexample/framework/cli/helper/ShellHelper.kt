package com.jss.springshellexample.framework.cli.helper

import org.jline.terminal.Terminal
import org.jline.utils.AttributedStringBuilder
import org.jline.utils.AttributedStyle
import org.springframework.beans.factory.annotation.Value

class ShellHelper(private val terminal: Terminal?) {
    @Value("\${shell.out.info}")
    lateinit var infoColor: String

    @Value("\${shell.out.success}")
    lateinit var successColor: String

    @Value("\${shell.out.warning}")
    lateinit var warningColor: String

    @Value("\${shell.out.error}")
    lateinit var errorColor: String

    @Value("\${shell.out.default}")
    lateinit var defaultColor: String

    private fun getColored(message: String, color: PromptColor): String {
        return AttributedStringBuilder().append(
            message,
            AttributedStyle.DEFAULT.foreground(color.toJLineAttributedStyle())
        ).toAnsi()
    }

    fun getInfoMessage(message: String): String {
        return getColored(message, PromptColor.valueOf(infoColor))
    }

    fun getSuccessMessage(message: String): String {
        return getColored(message, PromptColor.valueOf(successColor))
    }

    fun getWarningMessage(message: String): String {
        return getColored(message, PromptColor.valueOf(warningColor))
    }

    fun getErrorMessage(message: String): String {
        return getColored(message, PromptColor.valueOf(errorColor))
    }

    fun print(message: String) {
        print(message, PromptColor.valueOf(defaultColor))
    }

    fun printSuccess(message: String) {
        print(message, PromptColor.valueOf(successColor))
    }

    fun printInfo(message: String) {
        print(message, PromptColor.valueOf(infoColor))
    }

    fun printWarning(message: String) {
        print(message, PromptColor.valueOf(warningColor))
    }

    fun printError(message: String) {
        print(message, PromptColor.valueOf(errorColor))
    }

    private fun print(message: String, color: PromptColor) {
        val toPrint = getColored(message, color)
        terminal!!.writer().println(toPrint)
        terminal.flush()
    }
}