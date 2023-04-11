import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Отсотрировать стобцы матрицы по возрастанию и убыванию значений эементов.
 */
class Exercise_2_2_13 {
    public static void main(String[] args) {
        final MatrixSorter sorter = new MatrixSorterImpl();
        final MatrixPrinter printer = new MatrixPrinter.ConsoleMatrixPrinter();

        final List<List<Integer>> matrix = new ArrayList<List<Integer>>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(9, 8, 7)));
                add(new ArrayList<Integer>(Arrays.asList(6, 5, 4)));
                add(new ArrayList<Integer>(Arrays.asList(3, 2, 1)));
                add(new ArrayList<Integer>(Arrays.asList(2, 1, 8)));
            }
        };

        System.out.println("The matrix:");
        printer.print(matrix);

        System.out.println("Matrix sorted by columns in increasing order:");
        sorter.sortColumnsIncreasing(matrix);
        printer.print(matrix);

        System.out.println("Matrix sorted by columns in decreasing order:");
        sorter.sortColumnsDecreasing(matrix);
        printer.print(matrix);
    }
}

interface MatrixSorter {
    public <T extends Number & Comparable<T>> void sortColumnsIncreasing(List<List<T>> matrix);

    public <T extends Number & Comparable<T>> void sortColumnsDecreasing(List<List<T>> matrix);
}

class MatrixSorterImpl implements MatrixSorter {

    @Override
    public <T extends Number & Comparable<T>> void sortColumnsDecreasing(List<List<T>> matrix) {
        for (int c = 0; c < matrix.get(0).size(); c++) {
            ArrayList<T> column = new ArrayList<T>();
            for (int r = 0; r < matrix.size(); r++) {
                column.add(matrix.get(r).get(c));
            }
            Collections.sort(column);
            for (int r = 0; r < matrix.size(); r++) {
                matrix.get(r).set(c, column.get(r));
            }
        }
    }

    @Override
    public <T extends Number & Comparable<T>> void sortColumnsIncreasing(List<List<T>> matrix) {
        for (int c = 0; c < matrix.get(0).size(); c++) {
            ArrayList<T> column = new ArrayList<T>();
            for (int r = 0; r < matrix.size(); r++) {
                column.add(matrix.get(r).get(c));
            }
            Collections.sort(column);
            for (int r = 0; r < matrix.size(); r++) {
                matrix.get(r).set(c, column.get(matrix.size() - 1 - r));
            }
        }
    }

}