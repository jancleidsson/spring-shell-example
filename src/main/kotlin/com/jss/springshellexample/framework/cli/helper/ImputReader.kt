package com.jss.springshellexample.framework.cli.helper

import org.jline.reader.LineReader

class InputReader(private val lineReader: LineReader?, private val mask: Char? = DEFAULT_MASK) {

    @JvmOverloads
    fun prompt(prompt: String, defaultValue: String? = null, echo: Boolean = true): String? {
        val answer = if (echo) {
            lineReader!!.readLine("$prompt: ")
        } else {
            lineReader!!.readLine("$prompt: ", mask)
        }
        return if (answer.isNotBlank()) {
            defaultValue
        } else answer
    }

    companion object {
        const val DEFAULT_MASK = '*'
    }
}