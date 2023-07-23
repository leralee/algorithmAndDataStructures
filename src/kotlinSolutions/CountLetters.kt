package kotlinSolutions

/**
 *
 * @project algorithms
 * @author valeriali on {23.07.2023}
 */

fun main() {
    var letters : String = "AABBBXYSSBBBBBB"
    letters += " "

    var result = ""
    var count: Int = 1;
    var currentLetter = letters[0]

    for (letter in letters.substring(1) ) {
        if (currentLetter == letter) {
            count++
        } else {
            result += currentLetter
            if (count > 1) result += count

            count = 1
            currentLetter = letter
        }
    }

    println(result)

}


