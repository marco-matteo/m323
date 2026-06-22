package pureFunctions

import org.junit.jupiter.api.Test
import java.util.Date
import kotlin.test.assertEquals

object TestFunctions3p3 {
    @Test
    fun test3p1() {
        assertEquals(listSum(listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)),45)
    }

    @Test
    fun test3p2() {
        assertEquals(listAverage(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), 5.5)
    }

    @Test
    fun test3p3() {
        assertEquals(
            sortList(listOf("ABC", "XYZ", "123")),
            listOf("123", "ABC", "XYZ"),
        )
    }

    @Test
    fun test3p4() {
        val obj1 = ListObject(Date(0), 1, "Kotlin")
        val obj2 = ListObject(Date(0), 2, "Java")
        val obj3 = ListObject(Date(0), 1, "Scala")
        val list = listOf(obj1, obj2, obj3)
        assertEquals(sort(list), listOf(obj1, obj3, obj2))
    }

    @Test
    fun test3p5() {
        val leaf1 = Node()
        val leaf2 = Node()
        val root = Node(listOf(leaf1, leaf2))

        assertEquals(listOf(leaf1, leaf2), readNode(root))
    }
}