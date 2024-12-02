import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day3SolutionRunnerTest {

    @Test
    fun `run day 3 part 1 solution`() {
        val expected = 0
        val inputData = ("").split("\n").stream()

        assertEquals(expected, Day3().getPart1Solution(inputData).toInt())
    }

    @Test
    fun `run day 3 part 2 solution`() {
        val expected = 0
        val inputData = ("").split("\n").stream()

        assertEquals(expected, Day3().getPart2Solution(inputData).toInt())
    }

}