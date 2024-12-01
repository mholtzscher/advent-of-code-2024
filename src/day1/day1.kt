package day1

import java.io.File
import kotlin.math.abs

//fun main() {
//    val left: MutableList<Int> = mutableListOf()
//    val right: MutableList<Int> = mutableListOf()
//
//    File("src/day1/input.txt").readLines().map { line ->
//        val (l, r) = line.split("   ").map { it.toInt() }
//        left.add(l)
//        right.add(r)
//    }
//    left.sort()
//    right.sort()
//
//    part1(left, right)
//}
//
//fun part1(left: MutableList<Int>, right: MutableList<Int>) {
//    var sum = 0
//    for (i in left.indices) sum += abs(right[i] - left[i])
//
//    println(sum)
//}


fun main() {
    val (left, right) = File("src/day1/input.txt")
        .readLines()
        .map { line ->
            line.split("   ")
                .map { it.toInt() }
                .let { (l, r) -> l to r }
        }
        .unzip()

    val sortedLeft = left.sorted()
    val sortedRight = right.sorted()

    val absoluteDifferenceSum = sortedLeft.zip(sortedRight)
        .sumOf { (l, r) -> abs(r - l) }
    println(absoluteDifferenceSum)
}
