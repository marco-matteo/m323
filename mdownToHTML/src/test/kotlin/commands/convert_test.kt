package commands

import Header
import MarkdownObject
import OrderedList
import Paragraph
import UnorderedList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

object TestParseMarkdown {
    @Test
    fun testEmptyList() {
        assertEquals(emptyList<MarkdownObject>(), parseMarkdown(emptyList()))
    }

    @Test
    fun testHeaders() {
        val headers = listOf("# Header 1", "## Header 2", "### Header 3")
        val mdObjects = listOf<MarkdownObject>(Header(1, "Header 1"), Header(2, "Header 2"), Header(3, "Header 3"))
        assertEquals(mdObjects, parseMarkdown(headers))
    }

    @Test
    fun testUnorderedList() {
        val lines = listOf("- one", "- two", "* three", "+ four")
        val mdObjects = listOf<MarkdownObject>(UnorderedList(entries = listOf("one", "two", "three", "four")))
        assertEquals(mdObjects, parseMarkdown(lines))
    }

    @Test
    fun testOrderedList() {
        val lines = listOf("1. first", "2. second", "10. tenth")
        val mdObjects = listOf<MarkdownObject>(OrderedList(entries = listOf("first", "second", "tenth")))
        assertEquals(mdObjects, parseMarkdown(lines))
    }

    @Test
    fun testSplitList() {
        val lines = listOf("- one", "# Heading", "- two")
        val mdObjects = listOf<MarkdownObject>(UnorderedList(entries = listOf("one")), Header(1, "Heading"), UnorderedList(entries = listOf("two")))
        assertEquals(mdObjects, parseMarkdown(lines))
    }
}

object TestTextStyleConvert {
    @Test
    fun testPlainTextUnchanged() {
        val line = "no markdown here"
        assertEquals(line, textStyleConvert(line))
    }

    @Test
    fun testBoldAsterisk() {
        val line = "**bold**"
        assertEquals("<b>bold</b>", textStyleConvert(line))
    }

    @Test
    fun testBoldUnderscore() {
        val line = "__bold__"
        assertEquals("<b>bold</b>", textStyleConvert(line))
    }

    @Test
    fun testItalicAsterisk() {
        val line = "*italic*"
        assertEquals("<i>italic</i>", textStyleConvert(line))
    }

    @Test
    fun testItalicUnderscore() {
        val line = "_italic_"
        assertEquals("<i>italic</i>", textStyleConvert(line))
    }

    @Test
    fun testLink() {
        val line = "[Google](https://google.com)"
        assertEquals("<a href=\"https://google.com\">Google</a>", textStyleConvert(line))
    }

    @Test
    fun testImage() {
        val line = "![alt text](https://example.com/img.png)"
        assertEquals("<img src=\"https://example.com/img.png\" alt=\"alt text\">", textStyleConvert(line))
    }

    @Test
    fun testImageWithEmptyAlt() {
        val line = "![](https://example.com/img.png)"
        assertEquals("<img src=\"https://example.com/img.png\" alt=\"\">", textStyleConvert(line))
    }

    @Test
    fun testMultipleBoldInSameLine() {
        val line = "**a** and **b**"
        assertEquals("<b>a</b> and <b>b</b>", textStyleConvert(line))
    }

    @Test
    fun testBoldAndItalicCombined() {
        val line = "**bold** and *italic*"
        assertEquals("<b>bold</b> and <i>italic</i>", textStyleConvert(line))
    }

    @Test
    fun testLinkAndImageSameLine() {
        val line = "![alt](img.png) and [text](page.html)"
        assertEquals(
            "<img src=\"img.png\" alt=\"alt\"> and <a href=\"page.html\">text</a>",
            textStyleConvert(line)
        )
    }
}

object TestConvertMarkdown {
    @Test
    fun testHeader() {
        val header = Header(1, "Header 1")
        assertEquals("<h1>Header 1</h1>", convertMarkdown(listOf(header))[0])
    }

    @Test
    fun testUnorderedList() {
        val list = UnorderedList(entries = listOf("one", "two", "three", "marco"))
        assertEquals("<ul><li>one</li><li>two</li><li>three</li><li>marco</li></ul>", convertMarkdown(listOf(list))[0])
    }

    @Test
    fun testOrderedList() {
        val list = OrderedList(entries = listOf("ten", "nine", "eight", "matteo"))
        assertEquals("<ol><li>ten</li><li>nine</li><li>eight</li><li>matteo</li></ol>", convertMarkdown(listOf(list))[0])
    }

    @Test
    fun testParagraph() {
        val paragraph = Paragraph("This is the Content")
        assertEquals("<p>This is the Content</p>", convertMarkdown(listOf(paragraph))[0])
    }
}

object TestBuildHTML {
    @Test
    fun testBuildNoCss() {
        assertEquals(        """
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Generated</title>
    
</head>
<body>
</body>
</html>
    """.trimIndent(), buildHTML(listOf(), null))
    }

    @Test
    fun testBuildWithCss() {
        assertEquals("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Generated</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
</body>
</html>
    """.trimIndent(), buildHTML(listOf(), "style.css"))
    }

    @Test
    fun testWithContent() {
        assertEquals("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Generated</title>
    <link rel="stylesheet" href="style.css">
</head>
<body><p>This is the Content</p>
</body>
</html>
        """.trimIndent(), buildHTML(listOf("<p>This is the Content</p>"), "style.css"))
    }

}