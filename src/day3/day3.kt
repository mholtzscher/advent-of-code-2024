package day3

import java.io.File

fun main() {
    val input = File("src/day3/input.txt").readText()
    part1(input)
}

fun part1(input: String) {
    val expression = Regex("mul\\((?<num1>\\d+),(?<num2>\\d+)\\)")

    val sum =
        expression.findAll(input).map { it.groups["num1"]!!.value.toInt() * it.groups["num2"]!!.value.toInt() }.sum()
    println(sum)
}