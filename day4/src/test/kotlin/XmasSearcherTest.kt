import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class XmasSearcherTest {
    private val givenLinesCleaned = listOf(
        "....XXMAS.",
        ".SAMXMS...",
        "...S..A...",
        "..A.A.MS.X",
        "XMASAMX.MM",
        "X.....XA.A",
        "S.S.S.S.SS",
        ".A.A.A.A.A",
        "..M.M.M.MM",
        ".X.X.XMASX",
    )

    private val givenLinesOriginal = listOf(
        "MMMSXXMASM",
        "MSAMXMSMSA",
        "AMXSXMAAMM",
        "MSAMASMSMX",
        "XMASAMXAMM",
        "XXAMMXXAMA",
        "SMSMSASXSS",
        "SAXAMASAAA",
        "MAMMMXMMMM",
        "MXMXAXMASX",
    )

    private val givenLines = givenLinesOriginal

    @Test
    fun itShouldFindXMASVertical() {
        val xmasSearcher = XmasSearcher()
        val result = xmasSearcher.searchVertical(givenLines)

        assertEquals(1, result)
    }

    @Test
    fun itShouldFindXMASVerticalReversed() {
        val xmasSearcher = XmasSearcher()
        val result = xmasSearcher.searchVerticalReversed(givenLines)

        assertEquals(2, result)
    }

    @Test
    fun itShouldFindXMASHorizontal() {
        val xmasSearcher = XmasSearcher()
        val result = xmasSearcher.searchHorizontal(givenLines)

        assertEquals(3, result)
    }

    @Test
    fun itShouldFindXMASHorizontalReversed() {
        val xmasSearcher = XmasSearcher()
        val result = xmasSearcher.searchHorizontalReversed(givenLines)

        assertEquals(2, result)
    }


    @Test
    fun itShouldFindXmasInDiagonalLines() {
        val xmasSearcher = XmasSearcher()
        val result = xmasSearcher.searchDiagonal(givenLines)

        assertEquals(2, result)
    }

    @Test
    fun itShouldFindXmasInDiagonalLinesReversed() {
        val xmasSearcher = XmasSearcher()
        val result = xmasSearcher.searchDiagonalReversed(givenLines)

        assertEquals(8, result)
    }

    @Test
    fun itShouldFindInAllDirections() {
        val xmasSearcher = XmasSearcher()
        val result = xmasSearcher.searchAllDirections(givenLines)

        assertEquals(18, result)
    }
}