package sprint4.finals;

import java.io.*;
import java.util.*;

//ID №89159452

/**
 * @author valeriali on {17.07.2023}
 * @project algorithms
 */

/**
 *Принцип работы алгоритма:
 1) buildIndex: В этом методе строится индекс для каждого слова во входных документах.
 Индекс представляет собой карту (Map), где ключом является слово, а значением - список пар (sprint4.finals.Pair),
 представляющих документы, в которых это слово встречается, и сколько раз оно встречается в каждом документе.
 2) getRelevanceScore: Данный метод принимает запрос (query) в виде строки и
 существующий индекс (построенный в buildIndex). Затем он проходит по словам в запросе, находит документы,
 связанные с этими словами, и подсчитывает "релевантность" каждого документа.
 Релевантность документа определяется суммой количества вхождений слов из запроса в каждый документ.
 3) getTopRelevantDocuments: Этот метод принимает массив релевантности документов
 и возвращает список индексов (нумерация документов начинается с 0)
 топ-5 наиболее релевантных документов (документы с самой высокой релевантностью).

 Временная сложность алгоритма:

 buildIndex: Операции разделения строк и добавления элементов в хеш-таблицу выполняются за O(D),
 где D - количество документов. Внешний цикл по документам повторяется n раз,
 а внутренний цикл по словам в каждом документе повторяется в среднем L раз (количество слов в одном документе)
 Таким образом, общая временная сложность метода buildIndex составляет O(D * L).
 getRelevanceScore: Перебор слов в запросе выполняется за O(Q), где Q - количество слов в запросе.
 Для каждого слова мы находим соответствующие документы и выполняем операции суммирования,
 что занимает O(D), где D - количество документов в которых содержится слово.
 Поскольку эти операции выполняются для каждого слова, общая временная сложность getRelevanceScore составляет O(Q * D).
 getTopRelevantDocuments: Сортировка списка релевантности выполняется за O(D * log D), где D - количество документов.
 Однако в данной реализации возвращается только топ-5 релевантных документов,
 так что временная сложность ограничивается O(1).
 Таким образом, общая временная сложность алгоритма составляет O(D * L + Q * D),
 где D - количество документов, L - количество слов в документе, Q - количество слов в запросе

 Пространственная сложность алгоритма:

 Хранение индекса: Для каждого слова хранится список пар (sprint4.finals.Pair), представляющих документы и количество вхождений.
 В худшем случае, если каждое слово встречается в каждом документе,
 пространственная сложность будет O(D * L), где D - количество документов, L - количество слов в документе.
 Дополнительные структуры данных: Массивы и коллекции, используемые в методах, занимают дополнительное пространство,
 пропорциональное количеству документов D и длине запроса Q.
 Таким образом, общая пространственная сложность составляет O(D * L + Q + D).
 */



class Pair<K, V> {
    private final K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}


public class SearchSystem {
    public static Map<String, List<Pair<Integer, Integer>>> buildIndex(BufferedReader br, int n) throws IOException {
        Map<String, List<Pair<Integer, Integer>>> index = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String document = br.readLine();
            String[] words = document.split(" ");

            for (String word : words) {
                if (!index.containsKey(word)) {
                    index.put(word, new ArrayList<>());
                }

                List<Pair<Integer, Integer>> docsContainingWord = index.get(word);
                boolean found = false;
                for (Pair<Integer, Integer> pair : docsContainingWord) {
                    if (pair.getKey() == i) {
                        pair.setValue(pair.getValue() + 1);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    docsContainingWord.add(new Pair<>(i, 1));
                }
            }
        }

        return index;


    }

    public static int[] getRelevanceScore(String query, Map<String, List<Pair<Integer, Integer>>> index, int docIdx) {
        int[] scores = new int[docIdx];
        String[] queryWords = query.split(" ");
        Set<String> uniqueWordsInQuery = new HashSet<>(Arrays.asList(queryWords));

        for (String word : uniqueWordsInQuery) {
            List<Pair<Integer, Integer>> docsContainingWord = index.get(word);
            if (docsContainingWord != null) {
                for (Pair<Integer, Integer> pair : docsContainingWord) {
                    int count = pair.getValue();
                    int doc = pair.getKey();
                    scores[doc] += count;
                }
            }
        }

        return scores;
    }

    public static List<Integer> getTopRelevantDocuments(int[] scores) {
        List<Integer> relevantDocs = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > 0) {
                relevantDocs.add(i);
            }
        }
        relevantDocs.sort((a, b) -> {
            if (scores[a] != scores[b]) {
                return Integer.compare(scores[b], scores[a]);
            } else {
                return Integer.compare(a, b);
            }
        });
        return relevantDocs.subList(0, Math.min(5, relevantDocs.size()));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<String, List<Pair<Integer, Integer>>> index = buildIndex(br, n);

        int m = Integer.parseInt(br.readLine());


        for (int i = 0; i < m; i++) {
            String query = br.readLine();
            int[] scores = getRelevanceScore(query, index, n);
            List<Integer> relevantDocs = getTopRelevantDocuments(scores);
            for (int docIdx : relevantDocs) {
                bw.write((docIdx + 1) + " ");
            }
            bw.newLine();
        }


        bw.flush();
        bw.close();
        br.close();
    }
}



