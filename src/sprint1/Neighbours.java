package sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author valeriali on {31.05.2023}
 * @project algirithms
 */
public class Neighbours {
    private static List<Integer> getNeighbours(List<List<Integer>> matrix, int row, int col,
                                               int rowId, int colId) {
        List<Integer> result = new ArrayList<>();
        if ((rowId - 1) >= 0 ) {
            result.add(matrix.get(rowId - 1).get(colId));
        }
        if ((colId + 1) < col) {
            result.add(matrix.get(rowId).get(colId + 1));
        }
        if ((rowId + 1) < row) {
            result.add(matrix.get(rowId + 1).get(colId));
        }
        if ((colId - 1) >= 0) {
            result.add(matrix.get(rowId).get(colId - 1));
        }

        result.sort(Comparator.naturalOrder());
        return result;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int rowsCount = readInt(reader);
            int colsCount = readInt(reader);
            List<List<Integer>> matrix = readMatrix(reader, rowsCount);
            int rowId = readInt(reader);
            int colId = readInt(reader);
            List<Integer> neighbours = getNeighbours(matrix, rowsCount, colsCount, rowId, colId);
            for (int element : neighbours) {
                System.out.print(element + " ");
            }
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

    private static List<List<Integer>> readMatrix(BufferedReader reader, int rowsCount) throws IOException {
        List<List<Integer>> matrix = new ArrayList<>(rowsCount);
        for (int i = 0; i < rowsCount; i++) {
            matrix.add(readList(reader));
        }
        return matrix;
    }
}
