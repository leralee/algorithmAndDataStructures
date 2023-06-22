package sprint1;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author valeriali on {05.06.2023}
 * @project algorithms
 */
public class ListForm {
    private static List<Integer> getSum(List<Integer> numberList, int k, int numberLength) {
        List<Integer> result = new ArrayList<>();
        int carry = 0;
        for (int i = numberLength - 1; i >= 0; i--){
            int sum = numberList.get(i) + carry;
            if (i == numberLength - 1){
                sum += k;
            }
            result.add(sum % 10);
            carry = sum / 10;
        }

        while (carry > 0){
            result.add(carry % 10);
            carry /= 10;
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int numberLength = readInt(reader);
            List<Integer> numberList = readList(reader);
            int k = readInt(reader);
            List<Integer> sum = getSum(numberList, k, numberLength);
            for (int elem : sum) {
                writer.write(elem + " ");
            }
            writer.flush();
        }
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.asList(reader.readLine().split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}
