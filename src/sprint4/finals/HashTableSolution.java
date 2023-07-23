package sprint4.finals;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

//ID №89191238

/**
 * @author valeriali on {21.07.2023}
 * @project algorithms
 */

/**
 * Принцип работы алгоритма:
 *
  В данном решении реализована хеш-таблица с разрешением коллизий методом цепочек.
  Каждый элемент массива table является списком (LinkedList) элементов типа sprint4.finals.Entry<K, V>.
  1) При добавлении элемента в хеш-таблицу (put), вычисляется хеш ключа, определяется индекс массива и элемент
  добавляется в соответствующий список. Если элемент с таким ключом уже есть в хеш-таблице, его значение обновляется.
  2) При поиске элемента по ключу (get), также вычисляется хеш ключа, определяется индекс массива и производится поиск
  элемента в списке. Если элемент с таким ключом найден, его значение возвращается.
  В противном случае возвращается null.
  3) При удалении элемента по ключу (delete), также вычисляется хеш ключа, определяется индекс массива и производится
  поиск элемента в списке. Если элемент с таким ключом найден, он удаляется из списка и его значение возвращается.
  В противном случае возвращается null.
 * Оценка временной сложности:
 *
 * В среднем, операции добавления, поиска и удаления элементов в хеш-таблице
 * с методом цепочек разрешения коллизий выполняются за O(1).
 * Однако, в худшем случае, когда возникает много коллизий и все элементы попадают в один список,
 * временная сложность может стать O(n), где n - количество элементов в списке.
 * Однако, вероятность такого худшего случая низка при хорошо спроектированной хеш-функции
 * и достаточном размере таблицы.
 *
 * Оценка пространственной сложности:
 *
 * Пространственная сложность хеш-таблицы составляет O(n + m),
 * где n - количество элементов, которые будут добавлены, а m - размер массива table.
 * В худшем случае, когда все элементы хранятся в одном списке (при плохо спроектированной хеш-функции),
 * пространственная сложность может быть O(n), но это редкость при использовании хорошей хеш-функции и
 * разрешения коллизий методом цепочек. Обычно размер массива table (m) хорошо подбирается так,
 * чтобы минимизировать коллизии и обеспечить эффективное использование памяти.
 */
public class HashTableSolution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        HashTable<Integer, Integer> hashTable = new HashTable<>();

        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");
            if (command[0].equals("get")) {
                Integer value = hashTable.get(Integer.parseInt(command[1]));
                if (value == null) {
                    bw.write("None");
                    bw.newLine();
                } else {
                    bw.write(value + "");
                    bw.newLine();
                }

            } else if (command[0].equals("put")) {
                hashTable.put(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
            } else if (command[0].equals("delete")) {
                Integer value = hashTable.delete(Integer.parseInt(command[1]));
                if (value == null) {
                    bw.write("None");
                    bw.newLine();
                } else {
                    bw.write(value + "");
                    bw.newLine();
                }
            }

        }
        bw.flush();
        br.close();

    }
}

class HashTable<K, V> {

    private List<Entry<K,V>>[] table;
    private static final int INITIAL_CAPACITY = 10007;

    public HashTable() {
        table = new LinkedList[INITIAL_CAPACITY];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        table[index].add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = hash(key);
        if (table[index] == null) {
            return null;
        }

        for (Entry<K,V> entry : table[index]) {
            if (entry.getKey().equals(key)){
                return entry.getValue();
            }
        }
        return null;
    }

    public V delete(K key) {
        int index = hash(key);
        if (table[index] == null) {
            return null;
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                table[index].remove(entry);
                return entry.getValue();
            }
        }
        return null;
    }
}

class Entry<K, V> {
    private final K key;
    private V value;

    public Entry(K key, V value) {
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
