package sprint3;

import java.io.*;



/**
 * @author valeriali on {05.07.2023}
 * @project algorithms
 */
public class Wardrobe {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] array = new int[n];

        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        int[] result = countingSort(array, 3);

        for (int i = 0; i < result.length; i++) {
            writer.write(result[i] + " ");
        }
        writer.newLine();

        writer.flush();
        writer.close();
        reader.close();
    }

    public static int[] countingSort(int[] array, int k) {
        int[] countedValues = new int[k];
        for (int value : array) {
            countedValues[value]++;
        }

        int index = 0;
        for (int value = 0; value < k; value++) {
            for (int amount = 0; amount < countedValues[value]; amount++) {
                array[index] = value;
                index++;
            }
        }
        return array;
    }
}
