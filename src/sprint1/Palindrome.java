package sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author valeriali on {01.06.2023}
 * @project algirithms
 */
public class Palindrome {
    private static boolean isPalindrome(String text) {
        int left = 0;
        int right = text.length()-1;

        String textLower = text.toLowerCase();

        while (left < text.length() && right > 0 && left!=right){
            while (!Character.isLetterOrDigit(textLower.charAt(left))) {
                left += 1;
            }
            while (!Character.isLetterOrDigit(textLower.charAt(right))) {
                right -= 1;
            }
            if(textLower.charAt(left) == textLower.charAt(right)){
                left+=1;
                right-=1;
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String text = reader.readLine();
            if (isPalindrome(text)) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }
}
