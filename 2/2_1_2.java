import java.util.Arrays;

/*
 * Дана последовательность действительных чисел а1 ,а2 ,..., ап. 
 * Заменить все ее члены, большие данного Z, этим числом. Подсчитать количество замен.
 */
class Exercise_2_1_2 {
    public static void main(String[] args) {

        final int arraySize = 36;

        final double[] doubleArray = new double[arraySize];

        for (int i = 0; i < arraySize; i++) {
            doubleArray[i] = i;
        }

        System.out.println("The array looks " + Arrays.toString(doubleArray));

        final double z = 10.3;

        int substitutesNumber = 0;

        for (int i = 0; i < arraySize; i++) {
            if (doubleArray[i] > z) {
                doubleArray[i] = z;
                substitutesNumber++;
            }
        }

        System.out.println("Substitutes number: " + substitutesNumber);
        System.out.println("Now the array looks like this " + Arrays.toString(doubleArray));
    }
}
