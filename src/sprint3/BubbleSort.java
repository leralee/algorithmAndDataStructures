package sprint3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author valeriali on {27.06.2023}
 * @project algorithms
 */
public class BubbleSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] array = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(tokenizer.nextToken());
        }
        bubbleSort(n, array);
        reader.close();

    }

    public static void bubbleSort(int n, int[] array) throws IOException {

        boolean swapped = false;
        boolean printedLastArray = false;

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            } else {
                printArray(array, writer);
                printedLastArray = true;
            }

        }
        if (!printedLastArray) {
            printArray(array, writer);
        }

        writer.flush();
        writer.close();
    }

    public static void printArray(int[] array, BufferedWriter writer) throws IOException {
        for (int i = 0; i < array.length; i++) {
            writer.write(String.valueOf(array[i]));

            if (i < array.length - 1) {
                writer.write(" ");
            }
        }

        writer.newLine();
    }

}

