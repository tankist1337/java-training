import java.util.Arrays;

/*
 * Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
 */
class Exercise_2_2_2 {
    public static void main(String[] args) {
        double[][] squareMatrix = new double[5][5];

        // init elements
        for (int i = 0; i < squareMatrix.length; i++) {
            for (int j = 0; j < squareMatrix[i].length; j++) {
                squareMatrix[i][j] = i + j;
            }
        }

        // print matrix
        System.out.println("The matrix is ");
        for (double[] ds : squareMatrix) {
            System.out.println(Arrays.toString(ds));
        }

        if (squareMatrix.length != squareMatrix[0].length) {
            System.out.println("The matrix is not square!");
        } else {
            System.out.print("The main diagonal of the square matrix is ");
            for (int i = 0; i < squareMatrix.length; i++) {
                System.out.print(squareMatrix[i][i] + " ");
            }
            System.out.println();
        }

    }
}
