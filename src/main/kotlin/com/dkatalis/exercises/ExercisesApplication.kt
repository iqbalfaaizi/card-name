package com.dkatalis.exercises

import org.springframework.boot.autoconfigure.SpringBootApplication
//import org.springframework.boot.runApplication
@SpringBootApplication
class ExercisesApplication

const val maxLength = 24
fun capitalize(name: String): String {
	return name.trim().split("\\s+".toRegex()).joinToString(" ") {
		it.first().uppercase() + it.substring(1).lowercase()
	}
}

fun generateTruncatedName(fullName: String): String {
	val splittedName = fullName.trim().split("\\s+".toRegex())
	val fullNameTrimmed: MutableList<String> = ArrayList()
	var i = 0

	while (i < splittedName.size && fullNameTrimmed.joinToString(" ").length + splittedName[i].length < maxLength) {
		fullNameTrimmed.add(splittedName[i++])
	}

	return fullNameTrimmed.let {
		val lastNameTrimmed = splittedName.filter { name -> !fullNameTrimmed.contains(name) }
			.map { name -> name.first().toString() }
		it.addAll(lastNameTrimmed)
		it.joinToString(" ")
	}
}

fun generateCardName(inputName: String): String {
	val fullName = capitalize(inputName)

	if (fullName.length < maxLength) {
		return fullName
	}

	return generateTruncatedName(fullName)
}

fun main(args: Array<String>) {
	val inputName = if (args.isNotEmpty()) args[0] else readln()

	val cardName = generateCardName(inputName)

	println(cardName)
}
