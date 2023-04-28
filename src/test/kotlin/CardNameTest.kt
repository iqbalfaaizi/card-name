import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.Before
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class CardNameTest {
    private val out = ByteArrayOutputStream()

    @Before
    fun setup() {
        System.setOut(PrintStream(out))
    }

    @Test
    fun `should return Capitalize name`() {
        val result = generateCardName("john doe")

        assertEquals("John Doe", result)
    }

    @Test
    fun `should return full name if less or equal than 24 chars`() {
        val result = generateCardName("Eric Cristopehersenenson")

        assertEquals("Eric Cristopehersenenson", result)
    }

    @Test
    fun `should return trimmed last name if more than 24 length`() {
        val result = generateCardName("Lana Kristophersekemuning")

        assertEquals("Lana K", result)
    }

    @Test
    fun `should return trimmed last name if more than 24 length #2`() {
        val result = generateCardName("Lo Min Christian Jammerson")

        assertEquals("Lo Min Christian J", result)
    }

    @Test
    fun `should return trimmed last name if more than 24 length #3`() {
        val result = generateCardName("Lin Min Kristophersekemuning Cristopehersenenson Jefferson")

        assertEquals("Lin Min K C J", result)
    }

    @Test
    fun `should return camel cased name`() {
        val result = generateCardName("SAMUEL L JACKSON")

        assertEquals("Samuel L Jackson", result)
    }
}