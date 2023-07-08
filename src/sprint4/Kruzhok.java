package sprint4;

import java.io.*;
import java.util.ArrayList;


/**
 * @author valeriali on {07.07.2023}
 * @project algorithms
 */
public class Kruzhok {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(reader.readLine());

        ArrayList<String> kruzhki = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String kruzhok = reader.readLine();
            if (!kruzhki.contains(kruzhok)) {
                kruzhki.add(kruzhok);
            }
        }

        for (String kruzhok : kruzhki) {
            System.out.println(kruzhok);
        }

        writer.flush();
        writer.close();
        reader.close();
    }
}
