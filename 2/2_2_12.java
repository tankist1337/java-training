import java.util.Arrays;

/*
 * Отсортировать строки матрицы по возрастанию и убыванию значений элементов.
 */
class Exercise_2_2_12 {
    public static void main(String[] args) {
        final double[][] matrix = {
                { 7, 5, 2, 6, 4 },
                { 5, 2, 4, 0, 1 },
                { 6, 5, 5, 3, 2 }
        };

        System.out.println("The matrix: ");
        for (double[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();

        for (double[] row : matrix) {
            Arrays.sort(row);
        }

        System.out.println("The final matrix after sorting rows: ");
        for (double[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
