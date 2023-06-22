package sprint1.finals;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author valeriali on {02.06.2023}
 * @project algirithms
 */
public class NearestZero1 {

    public static List<Integer> findNearestZero(String[] houses, int n){

        int d = n;
        List<Integer> distances = new ArrayList<>();
        for (String i : houses) {
            if (i.equals("0")) {
                d = 0;
            } else {
                d += 1;
            }
            distances.add(d);
        }
        return distances;
    }

    public static String[] reverseArray(String[] array) {
        String[] reversed = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[array.length - 1 - i] = array[i];
        }
        return reversed;
    }

    public static List<Integer> reverseList(List<Integer> list) {
        List<Integer> reversed = new ArrayList<>(list);
        Collections.reverse(reversed);
        return reversed;
    }


    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
            {
                int n = readInt(reader);
                String[] houses = reader.readLine().split(" ");
                List<Integer> toLeft = findNearestZero(houses, n);

                System.out.println(toLeft);

                List<Integer> toRight = reverseList(findNearestZero(reverseArray(houses), n));
                List<Integer> result = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    result.add(Math.min(toLeft.get(i), toRight.get(i)));
                }

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
                for (int element : result) {
                    writer.write(element + " ");
                }
                writer.flush();

            }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }


}
