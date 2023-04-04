/*
 * Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.
 */
class Exercise_2_2_1 {
    public static void main(String[] args) {
        double[][] matrix = {
                { 7, 5, 2, 6, 4 },
                { 5, 2, 4, 0, 1 },
                { 6, 1, 5, 3, 2 }
        };

        System.out.println("Odd columns where the first element is greater than the last:");
        for (int j = 0; j < matrix[0].length; j++) {

            if ((j + 1) % 2 != 0) {
                if (matrix[0][j] > matrix[matrix.length - 1][j]) {

                    for (int i = 0; i < matrix.length; i++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
