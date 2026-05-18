package pureFunctions

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

object TestFunctions {
    @Test
    fun test1p1() {
        var cart = emptyList<String>()
        cart = addToCart(cart, "Apple")
        assertEquals(listOf("Apple"), cart)
        cart = addToCart(cart, "Banana")
        assertEquals(listOf("Apple", "Banana"), cart)
        cart = addToCart(cart, "Orange")
        assertEquals(listOf("Apple", "Banana", "Orange"), cart)

    }

    @Test
    fun test1p2() {
        assertEquals(8, add(5, 3))
        assertEquals(6, add(2, 4))
    }

    @Test
    fun test1p3() {
        assertEquals('S', firstCharacter("Scala"))
        assertEquals('O', firstCharacter("OpenAI"))
    }

    @Test
    fun test1p4() {
        val random = Math.random()

        assertEquals(5.0 * random, multiplyWithRandom(5.0, random))
        assertEquals(10.0 * random, multiplyWithRandom(10.0, random))
    }

    @Test
    fun test1p5() {
        assertEquals(5.0, divideNumbers(10.0, 2.0))
        assertEquals(2.0, divideNumbers(8.0, 4.0))
    }

    @Test
    fun test1p6() {
        println(returnString("M323"))
        assertEquals("M323", returnString("M323"))
    }
}