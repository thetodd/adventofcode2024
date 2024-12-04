import de.dailycoding.aoc.utils.SolutionRunner
import java.util.stream.Stream

class Day3 : SolutionRunner {
    override fun getPart1Solution(inputData: Stream<String>): String {
        inputData.map {
            CodeParser().parse(it)
        }.flatMap { it.stream() }.map {
            when (it) {
                is Multiplication -> it.result()
                else -> 0
            }
        }.reduce { a, b -> a + b }.let {
            return it.orElseThrow().toString()
        }
    }

    override fun getPart2Solution(inputData: Stream<String>): String {
        val commands = inputData.map {
            CodeParser().parse(it)
        }.flatMap { it.stream() }.toList()

        var codeEnabled = true
        commands.filter { command ->
            when(command) {
                is Enabler -> {
                    codeEnabled = true
                    false
                }
                is Disabler -> {
                    codeEnabled = false
                    false
                }
                else -> codeEnabled
            }
        }.map {
                when (it) {
                    is Multiplication -> it.result()
                    else -> 0
                }
            }.reduce { a, b -> a + b }.let {
                return it.toString()
            }
    }
}