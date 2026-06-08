package higherOrderFunctions

import kotlin.random.Random

val monthDays: MutableMap<String, Int> = mutableMapOf(
    "January" to 31,
    "February" to 28,
    "March" to 31,
    "April" to 30,
    "May" to 31,
    "June" to 30,
    "July" to 31,
    "August" to 31,
    "September" to 30,
    "October" to 31,
    "November" to 30,
    "December" to 31
)

fun generateDay(random: Random): List<Int> {
    val holder: MutableList<Int> = mutableListOf()
    val numOfValues = Random(random.nextLong()).nextInt(10, 20)
    repeat(numOfValues) {
        holder += Random(random.nextLong()).nextInt(1000)
    }
    return holder
}

fun generateMonth(month: Map.Entry<String, Int>, random: Random): List<List<Int>> {
    val monthValues = mutableListOf<List<Int>>()
    repeat(month.value) {
        monthValues += generateDay(random)
    }
    return monthValues
}

fun sum(list: List<Int>): Int {
    return list.reduce { acc, i -> acc + i }
}

fun average(list: List<Int>): Double {
    return sum(list).toDouble() / list.size
}

fun averageString(list: List<Double>): String {
    return list.fold("") { acc, i -> if (acc == "") i.toString() else "$acc, $i" }
}

fun checkLeapYear(year: Int): Boolean {
    return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
}

fun main() {
    println("Please enter a year")
    val year = readln()
    val random = Random(year.toLong())
    val leapYear = checkLeapYear(year.toInt())

    if (leapYear) {
        monthDays["February"] = 29
    }

    val averages: MutableList<Double> = mutableListOf()
    val holder: MutableList<Int> = mutableListOf()

    monthDays.forEach { month ->
        val monthValues = generateMonth(month, random).flatten()

        averages += average(monthValues)
        holder += monthValues

        println(month.key + ": " + monthValues.size + " Values")
    }

    println(averageString(averages))
    println("Sum " + sum(holder))
}