import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day3SolutionRunnerTest {

    @Test
    fun `run day 3 part 1 solution`() {
        val expected = 161
        val inputData = ("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))").split("\n").stream()

        assertEquals(expected, Day3().getPart1Solution(inputData).toInt())
    }

    @Test
    fun `run day 3 part 2 solution`() {
        val expected = 48
        val inputData = ("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))").split("\n").stream()

        assertEquals(expected, Day3().getPart2Solution(inputData).toInt())
    }

}