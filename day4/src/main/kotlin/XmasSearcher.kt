import java.util.regex.Pattern
import java.util.stream.Stream

class XmasSearcher {

    private fun countFindings(pattern: Pattern, lines: Stream<String>): Int {
        lines.map { line ->
            return@map line.split(pattern).size - 1
        }.reduce(0) { acc, i -> acc + i }.let { return it }
    }

    fun searchAllDirections(lines: List<String>): Int {
        val horizontal = searchHorizontal(lines)
        val horizontalReversed = searchHorizontalReversed(lines)
        val vertical = searchVertical(lines)
        val verticalReversed = searchVerticalReversed(lines)
        val diagonal = searchDiagonal(lines)
        val diagonalReversed = searchDiagonalReversed(lines)

        return horizontal + horizontalReversed + vertical + verticalReversed + diagonal + diagonalReversed
    }

    fun searchHorizontal(lines: List<String>): Int =
        countFindings(Pattern.compile("XMAS"), lines.stream())

    fun searchHorizontalReversed(lines: List<String>): Int =
        searchHorizontal(lines.map { it.reversed() })

    fun searchVertical(lines: List<String>): Int {
        val lineLength = lines[0].length

        val transposedLines =
            (0 until lineLength).map { i -> lines.map { line -> line[i] } }.map { it.joinToString("") }

        return searchHorizontal(transposedLines)
    }

    fun searchVerticalReversed(lines: List<String>): Int {
        val lineLength = lines[0].length

        val transposedLines =
            (0 until lineLength).map { i -> lines.map { line -> line[i] } }.map { it.joinToString("") }

        return searchHorizontalReversed(transposedLines)
    }

    fun searchDiagonal(lines: List<String>): Int {
        var count = 0
        for (lineIndex in lines.indices) {
            if (lineIndex > lines.size - 4) {
                break
            }

            val lineLength = lines[lineIndex].length
            for (charIndex in 0 until lineLength) {
                val leftCharIndexes = intArrayOf(charIndex, charIndex - 1, charIndex - 2, charIndex - 3)
                val rightCharIndexes = intArrayOf(charIndex, charIndex + 1, charIndex + 2, charIndex + 3)
                if (!leftCharIndexes.any { it < 0 }) {
                    // test left tree
                    val firstChar = lines[lineIndex][leftCharIndexes[0]]
                    val secondChar = lines[lineIndex + 1][leftCharIndexes[1]]
                    val thirdChar = lines[lineIndex + 2][leftCharIndexes[2]]
                    val fourthChar = lines[lineIndex + 3][leftCharIndexes[3]]
                    arrayOf(firstChar, secondChar, thirdChar, fourthChar).joinToString("").let { it ->
                        if (it == "XMAS") {
                            count++
                        }
                    }
                }
                if (!rightCharIndexes.any { it > lineLength - 1 }) {
                    // test right tree
                    val firstChar = lines[lineIndex][rightCharIndexes[0]]
                    val secondChar = lines[lineIndex + 1][rightCharIndexes[1]]
                    val thirdChar = lines[lineIndex + 2][rightCharIndexes[2]]
                    val fourthChar = lines[lineIndex + 3][rightCharIndexes[3]]
                    arrayOf(firstChar, secondChar, thirdChar, fourthChar).joinToString("").let {
                        if (it == "XMAS") {
                            count++
                        }
                    }
                }
            }
        }

        return count
    }

    fun searchDiagonalReversed(lines: List<String>): Int {
        var count = 0
        for (lineIndex in lines.indices) {
            if (lineIndex > lines.size - 4) {
                break
            }

            val lineLength = lines[lineIndex].length
            for (charIndex in 0 until lineLength) {
                val leftCharIndexes = intArrayOf(charIndex, charIndex - 1, charIndex - 2, charIndex - 3)
                val rightCharIndexes = intArrayOf(charIndex, charIndex + 1, charIndex + 2, charIndex + 3)
                if (!leftCharIndexes.any { it < 0 }) {
                    // test left tree
                    val firstChar = lines[lineIndex][leftCharIndexes[0]]
                    val secondChar = lines[lineIndex + 1][leftCharIndexes[1]]
                    val thirdChar = lines[lineIndex + 2][leftCharIndexes[2]]
                    val fourthChar = lines[lineIndex + 3][leftCharIndexes[3]]
                    arrayOf(firstChar, secondChar, thirdChar, fourthChar).joinToString("").let { it ->
                        if (it == "SAMX") {
                            count++
                        }
                    }
                }
                if (!rightCharIndexes.any { it > lineLength - 1 }) {
                    // test right tree
                    val firstChar = lines[lineIndex][rightCharIndexes[0]]
                    val secondChar = lines[lineIndex + 1][rightCharIndexes[1]]
                    val thirdChar = lines[lineIndex + 2][rightCharIndexes[2]]
                    val fourthChar = lines[lineIndex + 3][rightCharIndexes[3]]
                    arrayOf(firstChar, secondChar, thirdChar, fourthChar).joinToString("").let {
                        if (it == "SAMX") {
                            count++
                        }
                    }
                }
            }
        }

        return count
    }
}