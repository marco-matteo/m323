package errorHandling

fun parse(str: String): Result<Int> = runCatching { str.toInt() }

fun addition(a: String, b: String): Result<Int> {
    val num1 = parse(a).getOrElse { return Result.failure(it) }
    val num2 = parse(b).getOrElse { return Result.failure(it) }
    return Result.success(num1 + num2)
}

fun main() {
    println("Running")

    println(addition("a", "B"))
    println(addition("3", "5"))
}