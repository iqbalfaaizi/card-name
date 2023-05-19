package com.dkatalis.exercises

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [
    DataSourceAutoConfiguration::class,
    MongoAutoConfiguration::class,
    MongoDataAutoConfiguration::class
])
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}