sealed interface MarkdownObject {
    fun transform(): String
}

data class Header (val level: Int, val content: String) : MarkdownObject {
    override fun transform(): String {
        return "<h$level>${content}</h$level>"
    }
}

data class Paragraph(val content: String) : MarkdownObject {
    override fun transform(): String {
        return "<p>$content</p>"
    }
}

data class OrderedList(val entries: List<String>): MarkdownObject {
    override fun transform(): String {
        val listElements = entries.fold("") { acc, it -> "$acc<li>$it</li>" }
        return "<ol>$listElements</ol>"
    }
}

data class UnorderedList(val entries: List<String>) : MarkdownObject {
    override fun transform(): String {
        val listElements = entries.fold("") { acc, it -> "$acc<li>$it</li>" }
        return "<ul>$listElements</ul>"
    }
}
