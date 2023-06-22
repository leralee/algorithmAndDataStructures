import java.io.*;
import java.util.StringTokenizer;
// ID 88399139
/**
 * @author valeriali on {20.06.2023}
 * @project algorithms
 */

/*
    Принцип работы алгоритма заключается в использовании кольцевого буфера (циклического массива) для реализации дека
    с максимальным размером, определенным числом.

    При создании экземпляра класса Deq, мы инициализируем массив deq заданной вместимостью (capacity).

    Также у нас есть переменные head и tail, которые указывают на начало и конец дека соответственно.
    Переменная size отслеживает текущее количество элементов в деке.

    Методы pushBack и pushFront добавляют элементы в конец и начало дека соответственно.
    Они проверяют, есть ли еще свободное место в деке (size не превышает capacity).
    Если есть место, то элемент добавляется на соответствующую позицию (tail для pushBack и head для pushFront),
    и переменные head и tail обновляются с учетом кольцевого буфера.

    Методы popFront и popBack удаляют и возвращают первый и последний элементы дека соответственно.
    Они проверяют, есть ли элементы в деке (size не равно 0). Если есть элементы, то значение удаляется из
    соответствующей позиции (head для popFront и tail для popBack), переменные head и tail обновляются с учетом
    кольцевого буфера, и размер дека уменьшается.

    Алгоритм должен работать корректно по следующим причинам:

    Кольцевой буфер позволяет эффективно использовать доступное пространство массива.
    Проверки на доступность места (size < capacity) и наличие элементов (size > 0) гарантируют
    корректное выполнение операций. Если дек уже заполнен при добавлении нового элемента, выводится "error".
    Если дек пуст при удалении элемента, также выводится "error".

    Все операции выполняются за константное время O(1), так как доступ к элементам массива и обновление указателей
    осуществляются непосредственно через вычисление новых индексов с использованием остатка от деления.

    Оценка временной сложности:

    Время выполнения операций O(1) (константное время).

    Оценка пространственной сложности:

    Пространственная сложность алгоритма - O(m), где m - максимальный размер дека (capacity).
    Мы используем массив фиксированного размера, который занимает пространство,
    пропорциональное максимальному размеру дека.
*/

class Deq {
    int capacity;
    int size;
    int head;
    int tail;
    String[] deq;

    Deq(int capacity){
        deq = new String[capacity];
        this.capacity = capacity;
        size = 0;
        head = 0;
        tail = 0;
    }

    public void pushBack(String value){
        if (size != capacity){
            deq[tail] = value;
            tail = (tail + 1) % capacity;
            size++;
        } else System.out.println("error");
    }

    public void pushFront(String value){
        if (size != capacity){
            head = (head - 1 + capacity) % capacity;
            deq[head] = value;
            size++;

        } else System.out.println("error");
    }

    public void popFront(){
        if (size != 0){
            System.out.println(deq[head]);
            deq[head] = null;
            head = (head + 1) % capacity;
            size--;
        } else {
            System.out.println("error");
        }
    }

    public void popBack(){
        if (size != 0){
            tail = (tail - 1 + capacity) % capacity;
            String value = deq[tail];
            deq[tail] = null;
            size--;
            System.out.println(value);
        } else {
            System.out.println("error");
        }
    }
}

public class DeqSolution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int numberOfCommands = Integer.parseInt(reader.readLine());
            int capacity = Integer.parseInt(reader.readLine());

            Deq deq = new Deq(capacity);

            for (int i = 0; i < numberOfCommands; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                String command = tokenizer.nextToken();
                if (command.startsWith("push_front")) {
                    String value = tokenizer.nextToken();
                    deq.pushFront(value);
                } else if (command.startsWith("push_back")) {
                    String value = tokenizer.nextToken();
                    deq.pushBack(value);

                } else if (command.startsWith("pop_front")) {
                    deq.popFront();
                } else if (command.startsWith("pop_back")) {
                    deq.popBack();
                }
            }
        }
    }
}
