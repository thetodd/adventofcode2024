import kotlin.math.abs

class DistanceCalculator {

    fun calculateTupelDistance(item: ListItemTupel): Int {
        return abs(item.leftValue - item.rightValue)
    }

}