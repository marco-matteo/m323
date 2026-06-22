package datastructures

import java.io.File
import kotlin.math.sqrt

fun main() {
    val reader = File("./src/main/kotlin/datastructures/data/data.txt").bufferedReader()
    val container: MutableList<Int> = mutableListOf()

    reader.use { reader ->
        while (true) {
            val line = reader.readLine() ?: break
            container.add(lineNumber(line))
        }
    }

    val primeNumbers = container.filter { isPrimeNumber(it) }
    println(primeNumbers.fold(0) { acc, i ->
        if (i > acc) i else acc
    })
}

fun lineNumber(line: String): Int {
    val numbers = line.filter { it.isDigit() }
    val sum = numbers.fold(0) { acc, ch -> acc + ch.digitToInt() }
    return sum
}

fun isPrimeNumber(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (i in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % i == 0) return false
    }
    return true
}