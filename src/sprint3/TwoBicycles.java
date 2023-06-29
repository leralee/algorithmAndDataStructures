package sprint3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * @author valeriali on {26.06.2023}
 * @project algorithms
 */
public class TwoBicycles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] days = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            days[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int s = Integer.parseInt(reader.readLine());

        int firstDay = binarySearch(days, s, 0, days.length - 1);
        int secondDay = binarySearch(days, s * 2, firstDay, days.length - 1);


        System.out.println(firstDay + " " + secondDay);

        reader.close();

    }
    public static int binarySearch(int[] days, int target, int left, int right) {
        if (right < left && left!=0){
            return -1;
        }
        int mid = (left + right) / 2;
        if (days[mid] >= target && (mid==0 || days[mid - 1] < target)) {
            return mid + 1;
        } else if (target <=days[mid]) {
            return binarySearch(days, target, left, mid - 1);
        } else {
            return binarySearch(days, target, mid + 1, right);
        }
    }

}
