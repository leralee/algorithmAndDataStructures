package sprint4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author valeriali on {08.07.2023}
 * @project algorithms
 */
public class StrangeComparable {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

//        String s = bufferedReader.readLine();
//        String t = bufferedReader.readLine();
//
//        Map<Character, Integer> mapS = new HashMap<>();
//        Map<Character, Integer> mapT = new HashMap<>();

        // Заполнение хеш-таблицы mapS
//        for (char c : s.toCharArray()) {
//            mapS.put(c, mapS.getOrDefault(c, 0) + 1);
//        }
//
//        // Заполнение хеш-таблицы mapT
//        for (char c : t.toCharArray()) {
//            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
//        }
//
//        if (mapS.size() != mapT.size()) {
//            System.out.println("NO");
//            return;
//        }
//
//        for (Map.Entry<Character, Integer> entry : mapS.entrySet()) {
//            char c = entry.getKey();
//            int countS = entry.getValue();
//            int countT = mapT.getOrDefault(c, 0);
//
//            if (countS != countT) {
//                System.out.println("NO");
//                return;
//            }
//        }
//
//        System.out.println("YES");

        // думаю здесь можно лучше

        char[] s = bufferedReader.readLine().toCharArray();
        char[] t = bufferedReader.readLine().toCharArray();

        if (s.length != t.length) {
            System.out.println("NO");
            return;
        };

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < t.length; i++) {
            if (map.containsKey(s[i])) {
                if (t[i] != map.get(s[i])){
                    System.out.println("NO");
                    return;
                }
            } else {
                if (map.containsValue(t[i])) {
                    System.out.println("NO");
                    return;
                }
                map.put(s[i], t[i]);
            }
        }

        System.out.println("YES");


        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
