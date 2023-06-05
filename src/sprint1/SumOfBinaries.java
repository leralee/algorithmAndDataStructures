package sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author valeriali on {01.06.2023}
 * @project algirithms
 */
public class SumOfBinaries {
    private static String sumOfBinaries(List<String>  a, List<String> b) {
        int poiner1 = a.size()-1;
        int poiner2 = b.size()-1;
        int overflow = 0;
        StringBuilder result = new StringBuilder();
        while (poiner1>=0 && poiner2>=0){
            if (Integer.parseInt(a.get(poiner1)) + Integer.parseInt(b.get(poiner2)) + overflow == 2) {
                result.insert(0, 0);
                overflow = 1;
                poiner1 -= 1;
                poiner2 -= 1;
            } else if (Integer.parseInt(a.get(poiner1)) + Integer.parseInt(b.get(poiner2)) + overflow == 3) {
                result.insert(0, 1);
                overflow = 1;
                poiner1 -= 1;
                poiner2 -= 1;

            } else if (Integer.parseInt(a.get(poiner1)) + Integer.parseInt(b.get(poiner2)) + overflow == 0){
                result.insert(0, 0);
                poiner1-=1;
                poiner2-=1;
            } else {
                result.insert(0, 1);
                overflow = 0;
                poiner1-=1;
                poiner2-=1;
            }
        }
        while (poiner1>=0){
            if (Integer.parseInt(a.get(poiner1)) + overflow == 2) {
                result.insert(0, 0);
                overflow = 1;
                poiner1 -= 1;
            } else if (Integer.parseInt(a.get(poiner1)) + overflow == 0){
                result.insert(0, 0);
                poiner1-=1;
            } else {
                result.insert(0, 1);
                overflow = 0;
                poiner1-=1;
            }
        }
        while (poiner2>=0){
            if (Integer.parseInt(b.get(poiner2)) + overflow == 2) {
                result.insert(0, 0);
                overflow = 1;
                poiner2 -= 1;
            } else if (Integer.parseInt(b.get(poiner2)) + overflow == 0){
                result.insert(0, 0);
                poiner2-=1;
            } else {
                result.insert(0, 1);
                overflow = 0;
                poiner2-=1;
            }
        }

        if (overflow == 1){
            result.insert(0, 1);
        }


        return result.toString();

    }
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            List<String> a = Arrays.stream(reader.readLine().split("")).collect(Collectors.toList());
            List<String> b = Arrays.stream(reader.readLine().split("")).collect(Collectors.toList());
//            System.out.println(Arrays.stream(reader.readLine().split("")).collect(Collectors.toList()));
//            String b = reader.readLine();
            System.out.println(sumOfBinaries(a, b));
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
