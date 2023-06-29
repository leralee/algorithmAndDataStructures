package sprint3;

import java.io.*;

/**
 * @author valeriali on {28.06.2023}
 * @project algorithms
 */
public class BigNumber {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        String[] numbers = reader.readLine().split(" ");

        String largestNumber = findLargestNumber(numbers);
        writer.write(largestNumber);
        writer.newLine();

        writer.flush();
        writer.close();
        reader.close();

    }

    private static String findLargestNumber(String[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            String key = numbers[i];
            int j = i;

            while (j > 0 && compareNumbers(numbers[j-1], key) > 0) {
                numbers[j] = numbers[j - 1];
                j--;
            }

            numbers[j] = key;
        }

        StringBuilder largestNumber = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            largestNumber.append(numbers[i]);
        }

        return largestNumber.toString();
    }

    private static int compareNumbers(String a, String b) {
        String ab = a + b;
        String ba = b + a;

        return ba.compareTo(ab);
    }

}
