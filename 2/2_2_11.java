import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Матрицу 10x20 заполнить случайными числами от 0 до 15. 
 * Вывести на экран саму матрицу и номера строк, в которых число 5 встречается три и более раз.
 */
class Exercise_2_2_11 {
    public static void main(String[] args) {
        final int[][] randomMatrix = new int[10][20];

        for (int i = 0; i < randomMatrix.length; i++) {
            for (int j = 0; j < randomMatrix[0].length; j++) {
                randomMatrix[i][j] = ThreadLocalRandom.current().nextInt(0, 15);
            }
        }

        System.out.println("The matrix: ");
        for (int[] row : randomMatrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();

        System.out.print("Rows with 5 3+ times: ");
        for (int i = 0; i < randomMatrix.length; i++) {
            int amountOfFive = 0;
            for (int j = 0; j < randomMatrix[0].length; j++) {
                if (randomMatrix[i][j] == 5)
                    amountOfFive++;

                if (amountOfFive >= 3) {
                    System.out.print(i + 1 + " ");
                    amountOfFive = 0;
                    break;
                }
            }
        }
        System.out.println();
    }
}
