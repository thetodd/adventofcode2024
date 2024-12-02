import kotlin.math.abs

class Utils {

    fun isMostlyIncreasing(numbers: List<Int>): Boolean {
        var count = 0
        for (i in 0 until numbers.size - 1) {
            if (numbers[i] >= numbers[i + 1]) {
                count++
            }
        }
        return count <= 1
    }

    fun getFirstIndexNotValidDistance(numbers: List<Int>, minDistance: Int, maxDistance: Int): Int {
        for (i in 0 until numbers.size - 1) {
            if (abs(numbers[i + 1] - numbers[i]) > maxDistance || abs(numbers[i + 1] - numbers[i]) < minDistance) {
                return i+1
            }
        }
        return -1
    }

    fun getFirstIndexNotIncreasing(numbers: List<Int>): Int {
        for (i in 0 until numbers.size - 1) {
            if (numbers[i] >= numbers[i + 1]) {
                return i + 1
            }
        }
        return -1
    }

    fun getFirstIndexNotDecreasing(numbers: List<Int>): Int {
        for (i in 0 until numbers.size - 1) {
            if (numbers[i] <= numbers[i + 1]) {
                return i + 1
            }
        }
        return -1
    }

    fun isStaticallyIncreasing(numbers: List<Int>): Boolean {
        this.getFirstIndexNotIncreasing(numbers).let {
            return it == -1
        }
    }

    fun isStaticallyDecreasing(numbers: List<Int>): Boolean {
        this.getFirstIndexNotDecreasing(numbers).let {
            return it == -1
        }
    }

    fun listItemsInDistanceRange(numbers: List<Int>, minDistance: Int, maxDistance: Int): Boolean {
        for (i in 0 until numbers.size - 1) {
            if (abs(numbers[i + 1] - numbers[i]) > maxDistance || abs(numbers[i + 1] - numbers[i]) < minDistance) {
                return false
            }
        }
        return true
    }
}