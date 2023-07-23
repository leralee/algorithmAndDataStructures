package kotlinSolutions

import java.util.Arrays
import java.util.StringJoiner

/**
 *
 * @project algorithms
 * @author valeriali on {23.07.2023}
 */
fun main() {
    /**
     * Sample Input ("eat", "tea", "tan", "ate", "nat", "bat")
     * Sample Output I ["ate", "eat", "tea"J, ["nat", "tan"j, ['bat"]
    Т.е. сгруппировать слова по "общим буквам".
     */

    val words = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")

    println(groupWords(words))
}

fun groupWords(words: Array<String>) : List<List<String>> {
    val result: MutableList<List<String>> = mutableListOf()

    val map = mutableMapOf<String, MutableList<String>>()

    for (word in words) {
        val sortedWord = word.toCharArray().sorted().joinToString("")

        if (map.containsKey(sortedWord))
            map[sortedWord]?.add(word)
        else
            map[sortedWord] = mutableListOf(word)

    }
    println(map)

    for ((key, value) in map) {
        result.add(value)
    }

    return result
}