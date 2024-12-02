import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day2SolutionRunnerTest {

    @Test
    fun `run day 2 part 1 solution`() {
        val expected = 2
        val inputData = ("7 6 4 2 1\n" +
                "1 2 7 8 9\n" +
                "9 7 6 2 1\n" +
                "1 3 2 4 5\n" +
                "8 6 4 4 1\n" +
                "1 3 6 7 9").split("\n").stream()

        assertEquals(expected, Day2().getPart1Solution(inputData).toInt())
    }

    @Test
    fun `run day 2 part 2 solution`() {
        val expected = 16
        val inputData = ("7 6 4 2 1\n" +
                "1 2 7 8 9\n" +
                "9 7 6 2 1\n" +
                "1 3 2 4 5\n" +
                "8 6 4 4 1\n" +
                "1 3 6 7 9\n" +
                "91 92 89 87 84 81 78 75\n" +
                "1 2 3 4 5 9\n" +
                "48 46 47 49 51 54 56\n" +
                "1 1 2 3 4 5\n" +
                "1 2 3 4 5 5\n" +
                "5 1 2 3 4 5\n" +
                "1 4 3 2 1\n" +
                "1 6 7 8 9\n" +
                "1 2 3 4 3\n" +
                "9 8 7 6 7\n" +
                "7 10 8 10 11\n" +
                "29 28 27 25 26 25 22 20").split("\n").stream()

        assertEquals(expected, Day2().getPart2Solution(inputData).toInt())
    }
}