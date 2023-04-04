import java.util.Arrays;

/*
 * Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 * 1, 1, ..., 1, 1
 * 2, 2, ..., 2, 0
 * 3, 3, ..., 0, 0
 * .. . .. . . . ..
 * n-1, 0, ..., 0, 0
 * n, 0, ..., 0,0
 */
class Exercise_2_2_5 {
    public static void main(String[] args) {

        int n = 10;

        if ((n % 2) != 0) {
            System.out.println("the n (" + n + ") is not even number");
        } else {
            final int[][] matrix = new int[n][n];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length - i; j++) {
                    matrix[i][j] = i + 1;
                }
            }

            System.out.println("The matrix: ");
            for (int[] is : matrix) {
                System.out.println(Arrays.toString(is));
            }
        }

    }
}