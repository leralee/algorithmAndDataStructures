package sprint3.finals;// №88840383
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author valeriali on {02.07.2023}
 * @project algorithms
 */


/**
 Принцип работы алгоритма:

 При каждом шаге сортировки, алгоритм выбирает опорный элемент
 (в данном случае последний элемент массива), разделяет массив на две части:
 элементы, меньшие или равные опорному, и элементы, большие опорного.
 Затем, рекурсивно применяет сортировку для каждой части массива до тех пор,
 пока массив не будет полностью отсортирован.

 Оценка временной сложности:

 В худшем случае, когда массив уже отсортирован в обратном порядке,
 алгоритм будет выполняться за O(n^2) времени. Однако, в среднем случае,
 быстрая сортировка имеет временную сложность O(n log n).

 Оценка пространственной сложности:

 В худшем случае, когда массив полностью отсортирован, глубина рекурсии может достигнуть O(n).
 В среднем случае, оценка глубины рекурсии составляет O(log n)
 */

public class EffectiveQuickSort {
     static class Participant implements Comparable<Participant> {
        String login;
        int problemsSolved;
        int penalty;

        public Participant(String login, int problemsSolved, int penalty) {
            this.login = login;
            this.problemsSolved = problemsSolved;
            this.penalty = penalty;
        }

         @Override
         public int compareTo(Participant o) {
             if (this.problemsSolved != o.problemsSolved) {
                 return Integer.compare(o.problemsSolved, this.problemsSolved);
             }
             if (this.penalty != o.penalty) {
                 return Integer.compare(this.penalty, o.penalty);
             }
             return this.login.compareTo(o.login);
         }
     }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Participant[] participants = new Participant[n];
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            String login = input[0];
            int problemsSolved = Integer.parseInt(input[1]);
            int penalty = Integer.parseInt(input[2]);
            participants[i] = new Participant(login, problemsSolved, penalty);
        }

        quickSort(participants, 0, n-1);

        for (Participant participant : participants) {
            System.out.println(participant.login);
        }

    }

    private static void quickSort(Participant[] participants, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(participants, left, right);
            quickSort(participants, left, pivotIndex);
            quickSort(participants, pivotIndex + 1, right);
        }
    }

    public static int partition(Participant[] participants, int left, int right){

        int mid = (left + right) / 2;
        Participant pivot = participants[mid];

        int i = left;
        int j = right;

        while (i <= j) {
            while (participants[i].compareTo(pivot) < 0) {
                i++;
            }
            while (participants[j].compareTo(pivot) > 0) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(participants, i, j);
            i++;
            j--;
        }

        return j;
    }


    public static void swap(Participant[] participants, int i, int j) {
        Participant temp = participants[i];
        participants[i] = participants[j];
        participants[j] = temp;
    }

}
