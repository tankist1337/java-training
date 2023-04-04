import java.util.Arrays;

/*
 * В числовой матрице поменять местами два столбца любых столбца, 
 * т. е. все элементы одного столбца поставить на соответствующие им позиции другого, 
 * а его элементы второго переместить в первый. Номера столбцов вводит пользователь с клавиатуры.
 */
class Exercise_2_2_8 {
    public static void main(String[] args) {
        final double[][] matrix = {
                { 7, 5, 2, 6, 4 },
                { 5, 2, 4, 0, 1 },
                { 6, 1, 5, 3, 2 }
        };

        System.out.println("The start matrix: ");
        for (double[] ds : matrix) {
            System.out.println(Arrays.toString(ds));
        }

        final InputConsoleHelper iHelper = new InputConsoleHelper.ScannerHelper();
        int column1, column2;

        System.out.println();
        do {
            System.out.println("Enter the first column number: ");
            column1 = iHelper.getInt();
            System.out.println("Enter the second column number: ");
            column2 = iHelper.getInt();

            if (column1 <= 0 || column2 <= 0)
                System.out.println("Column number must be more than 0");
            else if (column1 >= matrix[0].length || column2 >= matrix[0].length)
                System.out.println("Columns must be less than matrix columns");
            System.out.println();

        } while (column1 <= 0 || column2 <= 0 || column1 >= matrix[0].length || column2 >= matrix[0].length);

        iHelper.close();

        for (int i = 0; i < matrix.length; i++) {
            final double tempDouble = matrix[i][column1];
            matrix[i][column1] = matrix[i][column2];
            matrix[i][column2] = tempDouble;
        }

        System.out.println("The result matrix: ");
        for (double[] ds : matrix) {
            System.out.println(Arrays.toString(ds));
        }

    }
}
