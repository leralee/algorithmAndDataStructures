package sprint3;

import java.util.*;

/**
 * @author valeriali on {27.06.2023}
 * @project algorithms
 */
public class Combination {
    private static Map<Character, String> digitLetters = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine();

        generateDigitLettersMap();
        getCombinations(digits, "", 0, digits.length());

    }

    public static void generateDigitLettersMap() {
        digitLetters.put('2', "abc");
        digitLetters.put('3', "def");
        digitLetters.put('4', "ghi");
        digitLetters.put('5', "jkl");
        digitLetters.put('6', "mno");
        digitLetters.put('7', "pqrs");
        digitLetters.put('8', "tuv");
        digitLetters.put('9', "wxyz");
    }

    public static void getCombinations(String digits, String currentCombination, int currentPosition, int length){
        if (currentPosition == length){
            System.out.print(currentCombination + " ");
            return;
        }
        char currentDigit = digits.charAt(currentPosition);
        String letters = digitLetters.get(currentDigit);

        for (int i = 0; i < letters.length(); i++){
            String newCombination = currentCombination + letters.charAt(i);
            getCombinations(digits, newCombination, currentPosition + 1, length);
        }
    }
}
