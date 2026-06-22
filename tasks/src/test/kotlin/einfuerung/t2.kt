package einfuerung

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

object ShoppingCartTest {
    @Test
    fun testA() {
        val cart = ShoppingCartA()
        cart.addItem("Test")
        assertEquals(0, cart.getDiscount())
        cart.addItem("Book")
        assertEquals(5, cart.getDiscount())
        cart.removeItem("Book")
        assertEquals(0, cart.getDiscount())
    }

    @Test
    fun testB() {
        val cart = ShoppingCartB()
        cart.addItem("Test")
        assertEquals(0.0, cart.calcDiscount())
        cart.addItem("Book")
        assertEquals(0.05, cart.calcDiscount())
        cart.removeItem("Book")
        assertEquals(0.0, cart.calcDiscount())
    }

    @Test
    fun testC() {
        var cart = ShoppingCartC()
        cart = cart.addItem("Test")
        assertEquals(0.0, cart.calcDiscount())
        cart = cart.addItem("Book")
        assertEquals(0.05, cart.calcDiscount())
        cart = cart.removeItem("Book")
        assertEquals(0.0, cart.calcDiscount())
    }
}