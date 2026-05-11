package einfuerung.task1

class ShoppingCart {
    var cart = ArrayList<String>()
    var hasBook = false

    fun getDiscount() = if (hasBook) 5 else 0
    fun getItems() = cart

    fun addItem(article: String) {
        cart.add(article)
        if (cart.contains("Book")) {
            hasBook = true
        }
    }

    fun removeItem(article: String) {
        if (cart.contains(article)) {
            cart.remove(article)
        }
        if (!cart.contains("Book")) {
            hasBook = false
        }
    }
}

fun calcDiscount(articles: List<String>): Double {
    return if (articles.contains("Book")) {
        0.05
    } else {
        0.0
    }
}

fun addItem(oldList: List<String>, item: String): List<String> {
    return oldList + item
}

fun main() {
    val cart = ShoppingCart()
    cart.addItem("Test")
    println(cart.getItems())
    println(cart.getDiscount())

    println(calcDiscount(listOf("Book")))

    var oldList = listOf("Pen", "Book", "Glasses")
    println(addItem(oldList, "Test"))
    println(oldList)
}