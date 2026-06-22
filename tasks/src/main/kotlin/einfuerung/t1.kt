package einfuerung

fun calculateScore(word: String): Int {
    var score = 0
    for (c in word.toCharArray()) {
        if (c != 'a') {
            score++
        }
    }
    return score
}

fun wordScore(word: String): Int {
    return word.count {
        it != 'a'
    }
    // word.filter { c -> c != 'a' }.length
}

fun main() {
    println(calculateScore("imperative"))
    println(calculateScore("no"))
    println(wordScore("declarative"))
    println(wordScore("yes"))
}