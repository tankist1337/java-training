import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой
столбец содержит максимальную сумму.
 */
class Exercise_2_2_9 {
    public static void main(String[] args) {
        final double[][] matrix = {
                { 7, 5, 2, 6, 4 },
                { 5, 2, 3, 0, 12 },
                { 6, 1, 5, 3, 2 }
        };

        System.out.println("The matrix: ");
        for (double[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();

        final ElementCounter<double[][]> matrixCounter = new MatrixElementCounter();

        if (matrixCounter.hasNegativeElement(matrix)) {
            System.out.println("Matrix must not have negative elements");
        } else {

            final double[] columnSums = new double[matrix[0].length];

            for (int j = 0; j < matrix[0].length; j++) {
                for (int i = 0; i < matrix.length; i++) {
                    columnSums[j] += matrix[i][j];
                }
            }

            double maxSum = columnSums[0];
            final List<Integer> maxSumIndexes = new ArrayList<Integer>();

            for (int i = 0; i < columnSums.length; i++) {

                if (columnSums[i] > maxSum) {
                    maxSum = columnSums[i];

                    maxSumIndexes.clear();
                    maxSumIndexes.add(i);
                } else if (columnSums[i] == maxSum) {
                    maxSumIndexes.add(i);
                }
            }

            System.out.println("The index(-es) of the maximum column sum: " + maxSumIndexes);
        }
    }
}

interface ElementCounter<T> {

    boolean hasNegativeElement(T dataStructure);
}

class MatrixElementCounter implements ElementCounter<double[][]> {

    public MatrixElementCounter() {
    }

    @Override
    public boolean hasNegativeElement(double[][] dataStructure) {
        for (int i = 0; i < dataStructure.length; i++) {
            for (int j = 0; j < dataStructure[0].length; j++) {
                if (dataStructure[i][j] < 0)
                    return true;
            }
        }
        return false;
    }

}