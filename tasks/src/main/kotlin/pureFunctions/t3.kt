package pureFunctions

import java.util.Date

fun listSum(list: List<Int>): Int = list.sum()

fun listAverage(list: List<Int>): Double = list.average()

fun sortList(list: List<String>): List<String> = list.sorted()

data class ListObject(var date: Date, val priority: Int, var title: String)
fun sort(list: List<ListObject>): List<ListObject> {
    return list.sortedWith(compareBy({ it.date }, {it.priority}, {it.title}))
}

data class Node(
    val children: List<Node> = emptyList(),
)

fun readNode(node: Node): List<Node> {
    return node.children.flatMap { node ->
        if (node.children.isEmpty()) {
            listOf(node)
        } else {
            readNode(node)
        }
    }
}