package sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author valeriali on {22.06.2023}
 * @project algorithms
 */
public class FibonachiAbs {

    public static long fibonachi(int x, int k){
        long prev_1 = 1;
        long prev_2 = 1;
        long res = 1;

        for (int i=1; i<x; i++){
            System.out.println(prev_1+prev_2);
            res = Math.round((prev_1 + prev_2)%Math.pow(10,k));
            long temp = prev_1;
            prev_1 = res;
            prev_2 = temp;
            System.out.println(res);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bf.readLine());
        int x = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        System.out.println(fibonachi(x, k));




    }
}
