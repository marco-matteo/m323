package einfuerung

fun calculateTip(people: List<String>): Int {
    return when (people.size) {
        0 -> 0
        in 1..5 -> 10
        else -> 20
    }
}

fun main() {
    println(calculateTip(listOf("Fritz", "Franz", "Hugo", "Erwin", "Markus", "Martin", "Heiri")))
}