package com.ralphmarondev.spring_note

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringNoteApplication

fun main(args: Array<String>) {
	runApplication<SpringNoteApplication>(*args)
}
