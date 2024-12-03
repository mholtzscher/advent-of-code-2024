package day2

import java.io.File


fun main() {
    val input = File("src/day2/input.txt").readLines().map { it.split(" ").map { t -> t.toInt() } }
    part1(input)
    part2(input)
}

fun part1(input: List<List<Int>>) {
    var count = 0
    for (line in input) {
        if (isSafe(line)) {
            count++
        }
    }
    println(count)
}

fun part2(input: List<List<Int>>) {
    var count = 0
    for (line in input) {
        if (isSafe(line)) {
            count++
        } else {
            val safe = line.indices.any { skip -> isSafe(line.toMutableList().apply { removeAt(skip) }) }
            if (safe) count++
        }
    }
    println(count)
}

fun isSafe(input: List<Int>): Boolean {
    val deltas = input.zipWithNext { a, b -> b - a }
    return deltas.all { it in -1 downTo -3 } || deltas.all { it in 3 downTo 1 }
}
