import java.util.Arrays;

/*
 * Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 * 1 1 1 1 1 1 1
 * 0 1 1 1 1 1 0
 * 0 0 1 1 1 0 0
 * .... . . .  .
 * 0 1 1 1 1 1 0
 * 1 1 1 1 1 1 1
 */
class Exercise_2_2_6 {
    public static void main(String[] args) {

        int n = 12;

        if ((n % 2) != 0) {
            System.out.println("the n (" + n + ") is not even number");
        } else {
            final int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                if (i < n / 2) {
                    for (int j = i; j < n - i; j++) {
                        matrix[i][j] = 1;
                    }
                } else {
                    for (int j = n - 1 - i; j <= i; j++) {
                        matrix[i][j] = 1;
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
