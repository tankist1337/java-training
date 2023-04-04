import java.util.Arrays;

/**
 * Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 * 1, 2, 3, ..., n
 * n, n-1, n-2, ..., 1
 * 1, 2, 3, ..., n
 * n, n-1, n-2, ..., 1
 */
class Exercise_2_2_4 {
    public static void main(String[] args) {
        int n = 10;

        if (n % 2 != 0) {
            System.out.println("the n (" + n + ") is not even number");
        } else {

            int[][] matrix = new int[n][n];

            for (int i = 0; i < matrix.length; i++) {

                if ((i + 1) % 2 == 0) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][n - j - 1] = j + 1;
                    }
                } else {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = j + 1;
                    }
                }

            }

            System.out.println("The matrix: ");
            for (int[] is : matrix) {
                System.out.println(Arrays.toString(is));
            }
        }
    }
}