package einfuerung

class ShoppingCartA {
    var cart = mutableListOf<String>()
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

class ShoppingCartB {
    var cart = mutableListOf<String>()

    fun getItems() = cart
    fun addItem(article: String) {
        cart.add(article)
    }
    fun removeItem(article: String) {
        cart.remove(article)
    }

    fun calcDiscount(): Double {
        return if (cart.contains("Book")) {
            0.05
        } else {
            0.0
        }
    }
}

class ShoppingCartC(
    val cart: List<String> = listOf(),
) {
    fun addItem(article: String): ShoppingCartC {
        return ShoppingCartC(cart + article)
    }
    fun removeItem(article: String): ShoppingCartC {
        return ShoppingCartC(cart - article)
    }

    fun calcDiscount(): Double {
        return if (cart.contains("Book")) {
            0.05
        } else {
            0.0
        }
    }
}