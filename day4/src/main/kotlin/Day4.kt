import de.dailycoding.aoc.utils.SolutionRunner
import java.util.stream.Stream

class Day4 : SolutionRunner {
    override fun getPart1Solution(inputData: Stream<String>): String {
        return XmasSearcher().searchAllDirections(inputData.toList()).toString()
    }

    override fun getPart2Solution(inputData: Stream<String>): String {
        return "0"
    }
}