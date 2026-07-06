package commands

import Header
import MarkdownObject
import OrderedList
import Paragraph
import UnorderedList
import readFileFromPath
import writeFileIntoPath
import java.io.File
import java.io.Serializable

// Regex were generated using claude.ai
// I don't really have any fancy prompt it's just "hey generate me the regex for the following cases..."
// Something like that.

fun parse(target: String, result: String, cssFile: String?): Result<Unit> {
    val file = readFileFromPath(target).getOrElse { return Result.failure(it) }
    val fileStructure = parseMarkdown(file.readLines())
    val htmlLines = convertMarkdown(fileStructure)
val resultFile = buildHTML(htmlLines, cssFile)
    return writeFileIntoPath(result, resultFile)
}

fun parseMarkdown(lines: List<String>): List<MarkdownObject> {
    return lines.fold(emptyList()) { acc, line ->
        when {
            line.matches(Regex("^#{1,6} .*")) ->
                acc + Header(line.indexOf(" "), line.drop(line.indexOf(" ") + 1))
            line.matches(Regex("^[-*+] .*")) -> {
                val last = acc.lastOrNull()
                if (last is UnorderedList) acc.dropLast(1) + last.copy(entries = (last.entries + line.drop(line.indexOf(" ") + 1)))
                else acc + UnorderedList(mutableListOf(line.drop(line.indexOf(" ") + 1)))
            }
            line.matches(Regex("^\\d+\\. .*")) -> {
                val last = acc.lastOrNull()
                if (last is OrderedList) acc.dropLast(1) + last.copy(entries = (last.entries + line.drop(line.indexOf(" ") + 1)))
                else acc + OrderedList(mutableListOf(line.drop(line.indexOf(" ") + 1)))
            }
            else -> acc + Paragraph(line)
        }
    }
}

fun textStyleConvert(line: String): String {
    var result = line

    result = result.replace(Regex("!\\[([^]]*)]\\(([^)]+)\\)")) { match ->
        val (alt, url) = match.destructured
        "<img src=\"$url\" alt=\"$alt\">"
    }

    result = result.replace(Regex("\\[([^]]+)]\\(([^)]+)\\)")) { match ->
        val (text, url) = match.destructured
        "<a href=\"$url\">$text</a>"
    }

    result = result.replace(Regex("\\*\\*(.+?)\\*\\*"), "<b>$1</b>")
    result = result.replace(Regex("__(.+?)__"), "<b>$1</b>")

    result = result.replace(Regex("\\*(.+?)\\*"), "<i>$1</i>")
    result = result.replace(Regex("_(.+?)_"), "<i>$1</i>")

    return result
}

fun convertMarkdown(fileStructure: List<MarkdownObject>): List<String> {
    return fileStructure.map { textStyleConvert(it.transform()) }
}

fun buildHTML(body: List<String>, cssFile: String?): String {
    val cssLink = if (cssFile != null) {
        "<link rel=\"stylesheet\" href=\"$cssFile\">"
    } else {
        ""
    }

    val header = """
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Generated</title>
    $cssLink
</head>
<body>""".trimIndent()
    val footer = """
        </body>
        </html>
    """.trimIndent()

    val html = body.fold(header) { html, line ->
        html + line
    }
    return "$html\n$footer"
}