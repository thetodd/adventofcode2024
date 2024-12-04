package de.dailycoding.aoc.app

import Day1
import Day2
import Day3
import java.io.File
import java.io.InputStream

fun main() {

    val day = "Day3"

    val solutionRunners = mapOf(
        "Day1" to Day1(),
        "Day2" to Day2(),
        "Day3" to Day3(),
    )

    solutionRunners[day]?.let {
        val inputDataFile = "inputfiles/$day.txt"
        val solutionRunner = solutionRunners[day]!!

        val inputStreamPart1: InputStream = File(inputDataFile).inputStream()
        val inputStreamPart2: InputStream = File(inputDataFile).inputStream()
        val lines = inputStreamPart1.bufferedReader().lines()
        val linesPart2 = inputStreamPart2.bufferedReader().lines()

        println("The solution for " + day + " Part 1 is: " + solutionRunner.getPart1Solution(lines))
        println("The solution for " + day + " Part 2 is: " + solutionRunner.getPart2Solution(linesPart2))
    }

}
