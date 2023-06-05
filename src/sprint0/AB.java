package sprint0;

import java.util.Scanner;

/**
 * @author valeriali on {19.05.2023}
 * @project algirithms
 */
public class AB {
    private static int getSum(int a, int b) {
        return a+b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(getSum(a, b));
        scanner.close();
    }
}
