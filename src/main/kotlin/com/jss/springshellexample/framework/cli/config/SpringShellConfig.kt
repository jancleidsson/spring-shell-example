package com.jss.springshellexample.framework.cli.config

import com.jss.springshellexample.framework.cli.helper.InputReader
import com.jss.springshellexample.framework.cli.helper.ShellHelper
import org.jline.reader.LineReader
import org.jline.terminal.Terminal
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy

@Configuration
class SpringShellConfig {

    @Bean
    fun shellHelper(@Lazy terminal: Terminal?): ShellHelper {
        return ShellHelper(terminal)
    }

    @Bean
    fun inputReader(@Lazy lineReader: LineReader?): InputReader? {
        return InputReader(lineReader)
    }
}