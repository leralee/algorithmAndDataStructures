package sprint3;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author valeriali on {24.06.2023}
 * @project algorithms
 */
public class GeneratorOfBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        getSequenceBrackets(n, 0,0, sb);
    }

    public static void getSequenceBrackets(int n, int open, int close, StringBuilder sequence){

        if (sequence.length() == 2 * n){
            System.out.println(sequence);
            return;
        }
        if (open < n) {
            sequence.append("(");
            getSequenceBrackets(n, open+1, close, sequence);
            sequence.deleteCharAt(sequence.length()-1);
        }
        if (close < open) {
            sequence.append(")");
            getSequenceBrackets(n, open, close+1, sequence);
            sequence.deleteCharAt(sequence.length()-1);
        }
    }

}
