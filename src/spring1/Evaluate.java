package spring1;

import java.util.Scanner;

/**
 * @author valeriali on {31.05.2023}
 * @project algirithms
 */
public class Evaluate {
    private static int evaluateFunction(int a, int x, int b, int c) {
        int result = a*x*x+b*x+c;
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int x = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println(evaluateFunction(a, x, b, c));
        scanner.close();
    }
}
