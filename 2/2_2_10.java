import java.util.Arrays;

/*
 * Найти положительные элементы главной диагонали квадратной матрицы.
 */
class Exercise_2_2_10 {
    public static void main(String[] args) {
        final double[][] matrix = {
                { 1, 5, 2, 5, 6 },
                { 5, -2, 3, 0, 2 },
                { 6, 1, 1, 6, 9 },
                { 6, 1, 3, 0, 1 },
                { 6, 1, 5, 0, 3 }
        };

        System.out.println("The matrix: ");
        for (double[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();

        if (matrix.length != matrix[0].length) {
            System.out.println("The matrix is not square!");
        } else {
            System.out.print("The result: ");
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][i] > 0)
                    System.out.print(matrix[i][i] + " ");
            }
            System.out.println();
        }

    }
}
