package com.jss.springshellexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringShellExampleApplication

fun main(args: Array<String>) {
	runApplication<SpringShellExampleApplication>(*args)
}
