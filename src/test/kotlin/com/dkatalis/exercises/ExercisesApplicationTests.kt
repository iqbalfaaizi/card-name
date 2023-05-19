//package com.dkatalis.exercises
//
//import org.junit.jupiter.api.Assertions
//import org.junit.jupiter.api.BeforeEach
//import org.junit.jupiter.api.Test
//import org.springframework.boot.test.context.SpringBootTest
//import java.io.ByteArrayOutputStream
//import java.io.PrintStream
//
//@SpringBootTest
//class ExercisesApplicationTests {
//	private val out = ByteArrayOutputStream()
//
//	@BeforeEach
//	fun setup() {
//		System.setOut(PrintStream(out))
//	}
//	@Test
//	fun `should return Capitalize name`() {
//		val result = generateCardName("john doe")
//
//		Assertions.assertEquals("John Doe", result)
//	}
//
//	@Test
//	fun `should return full name if less or equal than 24 chars`() {
//		val result = generateCardName("Eric Cristopehersenenson")
//
//		Assertions.assertEquals("Eric Cristopehersenenson", result)
//	}
//
//	@Test
//	fun `should return trimmed last name if more than 24 length`() {
//		val result = generateCardName("Lana Kristophersekemuning")
//
//		Assertions.assertEquals("Lana K", result)
//	}
//
//	@Test
//	fun `should return trimmed last name if more than 24 length #2`() {
//		val result = generateCardName("Lo Min Christian Jammerson")
//
//		Assertions.assertEquals("Lo Min Christian J", result)
//	}
//
//	@Test
//	fun `should return trimmed last name if more than 24 length #3`() {
//		val result = generateCardName("Lin Min Kristophersekemuning Cristopehersenenson Jefferson")
//
//		Assertions.assertEquals("Lin Min K C J", result)
//	}
//
//	@Test
//	fun `should return camel cased name`() {
//		val result = generateCardName("SAMUEL L JACKSON")
//
//		Assertions.assertEquals("Samuel L Jackson", result)
//	}
//
//}
