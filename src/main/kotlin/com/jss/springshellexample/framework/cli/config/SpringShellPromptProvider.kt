package com.jss.springshellexample.framework.cli.config


import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.shell.jline.PromptProvider
import org.springframework.stereotype.Component;

@Component
class SpringShellPromptProvider : PromptProvider {
    override fun getPrompt(): AttributedString =
        AttributedString("CLI-DEMO:>", AttributedStyle.DEFAULT.foreground(AttributedStyle.BLUE));
}