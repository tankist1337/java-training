import java.util.Arrays;

/*
 * Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
 */
class Exercise_2_2_3 {
    public static void main(String[] args) {
        double[][] matrix = { { 3, 5, 1, 6, 2 }, { 3, 6, 8, 2, 1 }, { 5, 2, 4, 7, 2 }, { 7, 3, 1, 7, 3 },
                { 5, 1, 3, 6, 3 } };

        System.out.println("The matrix:");
        for (double[] ds : matrix) {
            System.out.println(Arrays.toString(ds));
        }
        System.out.println();

        int k = 3, p = 2;

        if (k >= matrix.length) {
            System.out.println("k is out of bands");
        } else if (p >= matrix[0].length) {
            System.out.println("p is out of bands");
        } else {
            System.out.println("k's row is " + Arrays.toString(matrix[k]));

            System.out.print("p's column is ");
            for (int i = 0; i < matrix[p].length; i++) {
                System.out.print(matrix[i][p] + " ");
            }
            System.out.println();
        }
    }
}