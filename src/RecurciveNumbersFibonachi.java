import java.util.Scanner;

/**
 * @author valeriali on {22.06.2023}
 * @project algorithms
 */
public class RecurciveNumbersFibonachi {
    public static int fibonachi(int x){
        if (x==1 || x==0){
            return 1;
        }
        return (fibonachi(x-1) + fibonachi(x-2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(fibonachi(x));
    }
}
