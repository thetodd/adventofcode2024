import java.util.regex.Matcher
import java.util.regex.Pattern

class CodeParser {

    fun parse(line: String): List<Command> {
        val regex = "don't\\(\\)|do\\(\\)|mul\\((\\d{1,3}),(\\d{1,3})\\)"
        val commands = mutableListOf<Command>()

        val pattern: Pattern = Pattern.compile(regex, Pattern.MULTILINE)
        val matcher: Matcher = pattern.matcher(line)

        while (matcher.find()) {
            val commandName = matcher.group(0).subSequence(0, matcher.group(0).indexOfFirst { c -> c == '(' })
            when (commandName) {
                "don't" -> commands.add(Disabler())
                "do" -> commands.add(Enabler())
                "mul" -> commands.add(Multiplication(matcher.group(1).toInt(), matcher.group(2).toInt()))
            }
        }

        return commands
    }

}

class Multiplication(private val a: Int, private val b: Int): Command("mul") {
    fun result(): Int {
        return a * b
    }
}

class Enabler(): Command("enable") {}

class Disabler(): Command("disable") {}

open class Command(val name: String)