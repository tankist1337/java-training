import java.util.Arrays;

/*
 * Сформировать квадратную матрицу порядка N по правилу:
 * A[I,J] = sin((I^2-J^2)/N)
 */
class Exercise_2_2_7 {
    public static void main(String[] args) {

        int n = 5;

        if (n <= 0) {
            System.out.println("N must be more than 0");
        } else {
            double[][] matrix = new double[n][n];

            int amountOfPositive = 0;

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {

                    matrix[i][j] = Math.sin((Math.pow(i, 2) - Math.pow(j, 2)) / n);

                    if (matrix[i][j] > 0)
                        amountOfPositive++;
                }
            }

            System.out.println("The formatted matrix with " + amountOfPositive + "  positive elements: ");
            for (double[] ds : matrix) {
                System.out.println(Arrays.toString(ds));
            }
        }
    }
}
