package de.dailycoding.aoc.utils

import java.util.stream.Stream

interface SolutionRunner {

    fun getPart1Solution(inputData: Stream<String>): String
    fun getPart2Solution(inputData: Stream<String>): String

}