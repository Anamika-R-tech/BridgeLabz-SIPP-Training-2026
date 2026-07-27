import java.util.*;

public class SensorPlacementNQueens {

    public static List<List<String>> placeSensors(int n) {
        List<List<String>> result = new ArrayList<>();

        int[] sensorColumn = new int[n];

        backtrack(n, 0, sensorColumn, result);

        return result;
    }

    private static void backtrack(
            int n,
            int row,
            int[] sensorColumn,
            List<List<String>> result) {

        if (row == n) {
            result.add(buildGrid(n, sensorColumn));
            return;
        }

        for (int column = 0; column < n; column++) {
            if (isSafe(row, column, sensorColumn)) {

                sensorColumn[row] = column;

                backtrack(
                        n,
                        row + 1,
                        sensorColumn,
                        result
                );
            }
        }
    }

    private static boolean isSafe(
            int currentRow,
            int currentColumn,
            int[] sensorColumn) {

        for (int previousRow = 0;
             previousRow < currentRow;
             previousRow++) {

            int previousColumn = sensorColumn[previousRow];

            // Same column
            if (previousColumn == currentColumn) {
                return false;
            }

            // Same diagonal
            if (Math.abs(previousColumn - currentColumn)
                    == Math.abs(previousRow - currentRow)) {
                return false;
            }
        }

        return true;
    }

    private static List<String> buildGrid(
            int n,
            int[] sensorColumn) {

        List<String> grid = new ArrayList<>();

        for (int row = 0; row < n; row++) {
            char[] currentRow = new char[n];
            Arrays.fill(currentRow, '.');

            currentRow[sensorColumn[row]] = 'S';

            grid.add(new String(currentRow));
        }

        return grid;
    }

    public static void main(String[] args) {
        int n = 4;

        List<List<String>> placements = placeSensors(n);

        for (List<String> placement : placements) {
            for (String row : placement) {
                System.out.println(row);
            }

            System.out.println();
        }
    }
}