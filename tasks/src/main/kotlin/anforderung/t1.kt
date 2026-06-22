package anforderung

import kotlin.system.exitProcess

fun main() {
    appLoop(emptyList())
}

fun printOptions(route: List<String>) {
    println("\n=== Current Route ===")
    if (route.isEmpty()) {
        println("(no stops)")
    } else {
        route.forEachIndexed { index, stop -> println("  ${index + 1}. $stop") }
    }
    println(
        """
        ====================
        1. Add a stop to the route
        2. Remove a stop from the route
        3. Delete the current route
        4. Exit program

        Enter number for given action: 
        """.trimIndent()
    )
}

fun listenToDestination(str: String = ""): String {
    if (str != "") {
        print(str)
    } else {
        print("\nEnter destination: ")
    }
    return readln().trim()
}

fun addDestination(route: List<String>, destination: String): List<String> = route + destination

fun removeDestination(route: List<String>, destination: String): List<String> {
    if (!route.contains(destination)) {
        println("'$destination' not found in route. Please try again.")
        return route
    }
    return route.filter { it != destination }
}

tailrec fun appLoop(route: List<String>): List<String> {
    printOptions(route)
    val updatedList = when (val selected = readln().trim()) {
        "1" -> addDestination(route, listenToDestination())
        "2" -> removeDestination(route, listenToDestination("\nEnter destination to delete: "))
        "3" -> emptyList<String>().also { println("Route deleted.") }
        "4" -> exitProcess(0)
        else -> route.also { println("'$selected' is not a valid option. Please try again.") }
    }

    return appLoop(updatedList)
}