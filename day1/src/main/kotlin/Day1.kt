import de.dailycoding.aoc.utils.SolutionRunner
import java.util.stream.Stream

class Day1 : SolutionRunner {

    override fun getPart1Solution(inputData: Stream<String>): String {
        val leftList = mutableListOf<String>()
        val rightList = mutableListOf<String>()

        inputData.forEach { line ->
            val split = line.split("\\s+".toRegex())
            leftList.add(split.first())
            rightList.add(split.last())
        }

        leftList.sortDescending()
        rightList.sortDescending()

        val list = mutableListOf<ListItemTupel>()

        for (i in 0 until leftList.size) {
            list.add(ListItemTupel(leftList[i].toInt(), rightList[i].toInt()))
        }

        val distanceCalculator = DistanceCalculator()

        return list.sumOf { distanceCalculator.calculateTupelDistance(it) }.toString()
    }

    override fun getPart2Solution(inputData: Stream<String>): String {
        val leftList = mutableListOf<String>()
        val rightList = mutableListOf<String>()

        inputData.forEach { line ->
            val split = line.split("\\s+".toRegex())
            leftList.add(split.first())
            rightList.add(split.last())
        }

        leftList.sortDescending()
        rightList.sortDescending()

        var similarityScore = 0

        for (i in 0 until leftList.size) {
            val count = rightList.count { it == leftList[i] }
            similarityScore += leftList[i].toInt() * count
        }

        return similarityScore.toString()
    }

}
