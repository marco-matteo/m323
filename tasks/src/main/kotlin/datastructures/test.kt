package datastructures

import java.io.File
import kotlin.math.sqrt

object Par {
    const val FILE_PATH = "data.txt"
    fun convertToNum(row: String): Int =
        row
            .filter { it.isDigit() }
            .map { it.digitToInt() }
            .fold(0) { acc, curr -> acc + curr }

    fun isPrime(n: Int): Boolean = when (n) {
        in Int.MIN_VALUE..1 -> false
        2 -> true
        else -> {
            if (n % 2 == 0) return false
            for (i in 3..sqrt(n.toDouble()).toInt() step 2) {
                if (n % i == 0) return false
            }
            return true
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val file = File(FILE_PATH)
        println(
            file.readLines()
                .parallelStream()
                .mapToInt { convertToNum(it) }
                .filter { isPrime(it) }
                .max()
                .orElse(0)
        )
    }
}