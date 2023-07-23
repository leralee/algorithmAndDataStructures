package kotlinSolutions

/**
 *
 * @project algorithms
 * @author valeriali on {22.07.2023}
 */
fun main() {
    val firstArray = mutableListOf(1, 1, 3, 2, 2, 0, 6, 8)
    val secondArray = mutableListOf(5, 1, 2, 7, 3, 2)

    val result : MutableList<Int> = mutableListOf()

    for (i in firstArray) {
        if (secondArray.contains(i))
            result.add(i)
            secondArray.remove(i)
    }

    println(result)
}