package sprint3;

import java.util.Arrays;

/**
 * @author valeriali on {01.07.2023}
 * @project algorithms
 */


public class MergeSort {
    public static int[] merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left; // размер первого подмассива
        int n2 = right - mid; // размер второго подмассива

        int[] leftArray = new int[n1]; // создаем временный массив для первого подмассива
        int[] rightArray = new int[n2]; // создаем временный массив для второго подмассива

        // копируем элементы во временные массивы
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + j];
        }

        int i = 0; // индекс для первого подмассива
        int j = 0; // индекс для второго подмассива
        int k = left; // индекс для объединенного массива

        // слияние двух подмассивов в один отсортированный массив
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // добавляем оставшиеся элементы из первого подмассива
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // добавляем оставшиеся элементы из второго подмассива
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }

        return arr;
    }

    public static void merge_sort(int[] arr, int left, int right) {
        if (left < right - 1) {
            int mid = (left + right) / 2; // находим середину подмассива

            // рекурсивно сортируем левую и правую половинки
            merge_sort(arr, left, mid);
            merge_sort(arr, mid, right);

            // объединяем две отсортированные половинки
            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{8,9,4,5,2,3};
        merge_sort(array, 0, array.length);
        System.out.println(Arrays.toString(array));
    }
}



