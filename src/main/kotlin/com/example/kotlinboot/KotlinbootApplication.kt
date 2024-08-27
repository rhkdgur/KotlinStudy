package com.example.kotlinboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinbootApplication

fun main(args: Array<String>) {
    runApplication<KotlinbootApplication>(*args)
}
