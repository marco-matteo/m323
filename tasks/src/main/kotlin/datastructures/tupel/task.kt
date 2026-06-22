package datastructures.tupel

import java.time.LocalTime

val data = listOf(
    ("Zurich" to 17),
    ("Bern" to 19),
    ("Geneva" to 21),
    ("Basel" to 18),
    ("Lugano" to 24),
    ("Lausanne" to 20),
    ("Lucerne" to 16),
    ("St. Gallen" to 14),
)

fun main() {
    println(getWeather())

    println(data.filter { it.second > 20})
}

fun getWeather(): Triple<String, LocalTime, Int> {
    return Triple("sonnig", LocalTime.now(), 17)
}