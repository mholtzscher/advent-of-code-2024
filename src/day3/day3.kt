package day3

import java.io.File

fun main() {
    val input = File("src/day3/input.txt").readText()
    part1(input)
    part2(input)
}

fun part1(input: String) {
    val expression = Regex("mul\\((?<num1>\\d+),(?<num2>\\d+)\\)")

    val sum =
        expression.findAll(input).map { it.groups["num1"]!!.value.toInt() * it.groups["num2"]!!.value.toInt() }.sum()
    println(sum)
}

fun part2(input: String) {
    val expression = Regex("do\\(\\)|mul\\((?<num1>\\d+),(?<num2>\\d+)\\)|don't\\(\\)")

    var filter = false
    val sum = expression.findAll(input).map {
        when {
            it.value == "do()" -> {
                filter = false
                0
            }

            it.value == "don't()" -> {
                filter = true
                0
            }

            !filter -> it.groups["num1"]!!.value.toInt() * it.groups["num2"]!!.value.toInt()
            else -> 0
        }
    }.sum()

    println(sum)
}