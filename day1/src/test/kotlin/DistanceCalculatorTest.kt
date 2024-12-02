import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class DistanceCalculatorTest {

     @ParameterizedTest
     @MethodSource("provideTestDistances")
     fun itShouldCalculateCorrectDistance(input: ListItemTupel, expected: Int) {
         val distanceCalculator = DistanceCalculator()
         val result = distanceCalculator.calculateTupelDistance(input)
         assertEquals(expected, result)
     }

    companion object {
        @JvmStatic
        fun provideTestDistances(): Stream<Arguments> {
            return listOf(
                Arguments.of(ListItemTupel(5, 3), 2),
                Arguments.of(ListItemTupel(3, 5), 2),
                Arguments.of(ListItemTupel(0, 0), 0),
                Arguments.of(ListItemTupel(0, 5), 5),
                Arguments.of(ListItemTupel(5, 0), 5),
            ).stream()
        }
    }

}