import org.junit.jupiter.api.Test

class DaySolutionRunnerTest {

    @Test
    fun `run day 1 solution`() {
        val expected = 11
        val inputData = ("3   4\n" +
                "4   3\n" +
                "2   5\n" +
                "1   3\n" +
                "3   9\n" +
                "3   3").split("\n").stream()

        assert(Day1().getPart1Solution(inputData).toInt() == expected)
    }
}