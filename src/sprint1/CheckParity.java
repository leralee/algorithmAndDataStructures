package sprint1;

import java.util.Scanner;

/**
 * @author valeriali on {01.06.2023}
 * @project algirithms
 */
public class CheckParity {
    private static boolean checkParity(int a, int b, int c) {

        return (a % 2 == 0 && b % 2 == 0 && c % 2 == 0) || (a % 2 != 0 && b % 2 != 0 && c % 2 != 0);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if (checkParity(a, b, c)) {
            System.out.println("WIN");
        } else {
            System.out.println("FAIL");
        }
        scanner.close();
    }

}
