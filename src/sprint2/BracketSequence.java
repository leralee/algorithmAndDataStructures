package sprint2;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author valeriali on {19.06.2023}
 * @project algorithms
 */
public class BracketSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (correctBracket(sc.nextLine())) System.out.println("True");
        else System.out.println("False");

    }

    public static boolean correctBracket(String brackets){
        if (brackets.isEmpty()) {
            return true;
        } else if (brackets.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for (char c : brackets.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            }
        }
        return stack.isEmpty();

    }

}