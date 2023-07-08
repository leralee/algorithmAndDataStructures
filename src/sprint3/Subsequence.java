package sprint3;

import java.io.*;

/**
 * @author valeriali on {29.06.2023}
 * @project algorithms
 */
public class Subsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        String t = reader.readLine();


        if (isSubsequence(s, t)) System.out.println("True");
        else System.out.println("False");

        reader.close();
    }

    public static boolean isSubsequence(String s, String t){
        int pointer1 = 0;
        int pointer2 = 0;

        while( pointer1 < s.length() && pointer2 < t.length() ){
            if (s.charAt(pointer1) == t.charAt(pointer2)){
                pointer1++;
            }
            pointer2++;
        }

        return  pointer1 == s.length();

    }
}
