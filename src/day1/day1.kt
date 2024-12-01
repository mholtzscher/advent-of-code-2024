package day1

import java.io.File
import kotlin.math.abs

fun main(){
    part1()
}
fun part1() {
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
