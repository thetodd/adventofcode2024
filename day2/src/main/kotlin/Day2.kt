import de.dailycoding.aoc.utils.SolutionRunner
import java.util.stream.Stream

class Day2 : SolutionRunner {

    override fun getPart1Solution(inputData: Stream<String>): String {
        inputData.map { line ->
            line.split(" ").map { it.toInt() }.toList()
        }.filter {
            Utils().isStaticallyIncreasing(it) || Utils().isStaticallyDecreasing(it)
        }.filter {
            Utils().listItemsInDistanceRange(it, 1, 3)
        }.count().let {
            return it.toString()
        }
    }

    override fun getPart2Solution(inputData: Stream<String>): String {
        inputData.map { line ->
            line.split(" ").map { it.toInt() }.toList()
        }.map {
            if (!Utils().isStaticallyIncreasing(it) && !Utils().isStaticallyDecreasing(it)) {
                if (Utils().isMostlyIncreasing(it)) {
                    val notIncreasingIndex = Utils().getFirstIndexNotIncreasing(it)
                    val filterIncreasingIndexed = it.filterIndexed { index, _ -> index != notIncreasingIndex }
                    val filterIncreasingIndexed2 = it.filterIndexed { index, _ -> index != notIncreasingIndex - 1 }
                    if (Utils().isStaticallyIncreasing(filterIncreasingIndexed)) {
                        return@map ListItemResult(it, filterIncreasingIndexed, true, false, -1, -1)
                    } else if (Utils().isStaticallyIncreasing(filterIncreasingIndexed2)) {
                        return@map ListItemResult(it, filterIncreasingIndexed2, true, false, -1, -1)
                    }
                    return@map ListItemResult(
                        it,
                        filterIncreasingIndexed,
                        false,
                        false,
                        notIncreasingIndex,
                        -1
                    )
                } else {
                    val notDecreasingIndex = Utils().getFirstIndexNotDecreasing(it)
                    val filterDecreasingIndexed = it.filterIndexed { index, _ -> index != notDecreasingIndex }
                    val filterDecreasingIndexed2 = it.filterIndexed { index, _ -> index != notDecreasingIndex - 1 }
                    if (Utils().isStaticallyDecreasing(filterDecreasingIndexed)) {
                        return@map ListItemResult(it, filterDecreasingIndexed, true, false, -1, -1)
                    } else if (Utils().isStaticallyDecreasing(filterDecreasingIndexed2)) {
                        return@map ListItemResult(it, filterDecreasingIndexed2, true, false, -1, -1)
                    }
                    return@map ListItemResult(
                        it,
                        filterDecreasingIndexed,
                        false,
                        false,
                        -1,
                        notDecreasingIndex
                    )
                }
            } else {
                if (!Utils().listItemsInDistanceRange(it, 1, 3)) {
                    // Tru to repair by removing one item
                    val notValidDistanceIndex = Utils().getFirstIndexNotValidDistance(it, 1, 3)
                    val filterDistanceIndexed = it.filterIndexed { index, _ -> index != notValidDistanceIndex }
                    val filterDistanceIndexed2 = it.filterIndexed { index, _ -> index != notValidDistanceIndex - 1 }
                    if (Utils().listItemsInDistanceRange(filterDistanceIndexed, 1, 3)) {
                        return@map ListItemResult(it, filterDistanceIndexed, true, true, -1, -1)
                    } else if (Utils().listItemsInDistanceRange(filterDistanceIndexed2, 1, 3)) {
                        return@map ListItemResult(it, filterDistanceIndexed2, true, true, -1, -1)
                    }
                }
                return@map ListItemResult(
                    it, it,
                    isValidByStatic = true,
                    isValidByDistances = false,
                    isIncreasingRepairedIndex = -1,
                    isDecreasingRepairedIndex = -1
                )
            }
        }.map { list ->
            return@map ListItemResult(
                list.originalList,
                list.repairedList,
                list.isValidByStatic,
                Utils().listItemsInDistanceRange(list.repairedList, 1, 3),
                list.isIncreasingRepairedIndex,
                list.isDecreasingRepairedIndex
            )
        }
            .filter { it.isValidByStatic && it.isValidByDistances }
            .count().let {
                return it.toString()
            }
    }

}

class ListItemResult(
    val originalList: List<Int>,
    val repairedList: List<Int>,
    val isValidByStatic: Boolean,
    val isValidByDistances: Boolean,
    val isIncreasingRepairedIndex: Int,
    val isDecreasingRepairedIndex: Int
) {
}