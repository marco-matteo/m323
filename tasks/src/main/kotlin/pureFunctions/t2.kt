package pureFunctions

// 1.1
fun addToCart(cart: List<String>, item: String): List<String> {
    return cart + item;
}

// 1.2
fun add(a: Int, b: Int): Int {
    return a + b;
}

// 1.3
fun firstCharacter(str: String): Char {
    return str.first()
}

// 1.4
fun multiplyWithRandom(number: Double, randomValue: Double): Double {
    return number * randomValue
}

// 1.5
fun divideNumbers(dividend: Double, divisor: Double): Double {
    return dividend / divisor
}

// 1.6
fun returnString(str: String): String {
    return str
}
