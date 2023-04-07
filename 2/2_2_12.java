import java.util.Arrays;
import java.util.Collections;

/*
 * Отсортировать строки матрицы по возрастанию и убыванию значений элементов.
 */
class Exercise_2_2_12 {
    public static void main(String[] args) {
        final Double[][] matrix = {
                { 7.0, 5.0, 2.0, 6.0, 4.0 },
                { 5.0, 2.0, 4.0, 0.0, 1.0 },
                { 6.0, 5.0, 5.0, 3.0, 2.0 }
        };

        System.out.println("The matrix: ");
        for (Double[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();

        System.out.println("Sorting by increasing order");
        for (Double[] row : matrix) {
            Arrays.sort(row);

            System.out.println(Arrays.toString(row));
        }
        System.out.println();

        System.out.println("Sorting by decreasing order: ");
        for (Double[] row : matrix) {
            Arrays.sort(row, Collections.reverseOrder());

            System.out.println(Arrays.toString(row));
        }
    }
}
