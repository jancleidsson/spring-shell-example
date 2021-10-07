package com.jss.springshellexample.framework.cli.helper

enum class PromptColor(private val value: Int) {
    BLACK(0), RED(1), GREEN(2), YELLOW(3), BLUE(4), MAGENTA(5), CYAN(6), WHITE(7), BRIGHT(8);

    fun toJLineAttributedStyle(): Int {
        return value
    }
}