import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day4SolutionRunnerTest {

    @Test
    fun `run day 4 part 1 solution`() {
        val expected = 18
        val inputData = ("MMMSXXMASM\n" +
                "MSAMXMSMSA\n" +
                "AMXSXMAAMM\n" +
                "MSAMASMSMX\n" +
                "XMASAMXAMM\n" +
                "XXAMMXXAMA\n" +
                "SMSMSASXSS\n" +
                "SAXAMASAAA\n" +
                "MAMMMXMMMM\n" +
                "MXMXAXMASX").split("\n").stream()

        assertEquals(expected, Day4().getPart1Solution(inputData).toInt())
    }

    @Test
    fun `run day 4 part 2 solution`() {
        val expected = 48
        val inputData = ("").split("\n").stream()

        assertEquals(expected, Day4().getPart2Solution(inputData).toInt())
    }

}