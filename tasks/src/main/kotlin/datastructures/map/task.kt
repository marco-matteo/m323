package datastructures.map

fun main() {
    val m1: Map<String, String> = mapOf(
        "key" to "value",
    )
    println(m1)

    val m2: Map<String, String> = m1 + ("key2" to "value2")
    println(m2)

    val m3: Map<String, String> = m2 + ("key2" to "diffValue")
    println(m3)

    val m4: Map<String, String> = m3 - "key"
    println(m4)

    val valueFromM3: String? = m3["key"]
    println(valueFromM3)

    val valueFromM4: String? = m4["key"]
    println(valueFromM4)
}


