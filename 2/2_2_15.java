import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.
 */
class Exercise_2_2_15 {
    public static void main(String[] args) {
        final List<List<Integer>> matrix = new ArrayList<List<Integer>>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(3, 8, 7)));
                add(new ArrayList<Integer>(Arrays.asList(6, 5, 4)));
                add(new ArrayList<Integer>(Arrays.asList(3, 2, 1)));
                add(new ArrayList<Integer>(Arrays.asList(2, 1, 8)));
            }
        };

        final MatrixPrinter printer = new MatrixPrinter.ConsoleMatrixPrinter();
        System.out.println("The start matrix: ");
        printer.print(matrix);

        Integer maxElement = getMaxElement(matrix);

        for (int r = 0; r < matrix.size(); r++) {
            for (int c = 0; c < matrix.get(0).size(); c++) {
                if (r % 2 == 0 && c % 2 == 0)
                    matrix.get(r).set(c, maxElement);
            }
        }

        System.out.println("The finish matrix: ");
        printer.print(matrix);

    }

    private static <T extends Number & Comparable<T>> T getMaxElement(final List<List<T>> matrix) {
        T maxElement = matrix.get(0).get(0);
        for (int r = 0; r < matrix.size(); r++) {
            for (int c = 0; c < matrix.get(0).size(); c++) {
                if (matrix.get(r).get(c).compareTo(maxElement) > 0)
                    maxElement = matrix.get(r).get(c);
            }
        }
        return maxElement;
    }
}
