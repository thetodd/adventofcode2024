import org.junit.jupiter.api.Test
import kotlin.test.assertFalse

class UtilsTest {
    @Test
    fun `it should return true if statically increasing list of numbers given`() {
        val numbers = listOf(1, 2, 3, 4, 5)
        assert(Utils().isStaticallyIncreasing(numbers))
    }

    @Test
    fun `it should return false if statically decreasing list of numbers given`() {
        val numbers = listOf(1, 2, 3, 4, 3)
        assert(!Utils().isStaticallyIncreasing(numbers))
    }

    @Test
    fun `it should return false for statically increase if list contains same numbers `() {
        val numbers = listOf(1, 2, 3, 3, 4)
        assert(!Utils().isStaticallyIncreasing(numbers))
    }

    @Test
    fun `it should return true if statically decreasing list of numbers given`() {
        val numbers = listOf(5, 4, 3, 2, 1)
        assert(Utils().isStaticallyDecreasing(numbers))
    }

    @Test
    fun `it should return false if statically increasing list of numbers given`() {
        val numbers = listOf(4, 3, 2, 3, 1)
        assert(!Utils().isStaticallyDecreasing(numbers))
    }

    @Test
    fun `it should return false for statically decreasing if list contains same numbers `() {
        val numbers = listOf(4, 3, 3, 2, 1)
        assert(!Utils().isStaticallyDecreasing(numbers))
    }

    @Test
    fun `it should return true if highest distance is not greater max distance`() {
        val numbers = listOf(1,2,4,5,6)
        assert(Utils().listItemsInDistanceRange(numbers, 1, 2))
    }

    @Test
    fun `it should return true if smallest distance is not less min distance`() {
        val numbers = listOf(1,2,4,5,6)
        assert(Utils().listItemsInDistanceRange(numbers, 1, 2))
    }

    @Test
    fun `it should return false if highest distance is greater max distance`() {
        val numbers = listOf(1,2,4,5,6)
        assertFalse(Utils().listItemsInDistanceRange(numbers, 1, 1))
    }

    @Test
    fun `it should return false if smallest distance is less min distance`() {
        val numbers = listOf(1,2,4,5,6)
        assertFalse(Utils().listItemsInDistanceRange(numbers, 2, 2))
    }

    @Test
    fun `it should return true if list is mostly increasing`() {
        val numbers = listOf(91, 92, 89, 87, 82, 81, 78, 74).reversed()
        assert(Utils().isMostlyIncreasing(numbers))
    }
}