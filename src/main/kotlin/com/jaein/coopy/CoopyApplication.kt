package com.jaein.coopy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CoopyApplication

fun main(args: Array<String>) {
	runApplication<CoopyApplication>(*args)
}
