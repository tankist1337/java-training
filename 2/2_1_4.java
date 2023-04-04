import java.util.Arrays;

/**
 * Даны действительные числа а1 ,а2 ,..., аn . Поменять местами наибольший и
 * наименьший элементы.
 */
class Exercise_2_1_4 {
    public static void main(String[] args) {

        double[] array = new double[] { -31.52, 0, 9, 3, -3, 7, 2, -3, 2, 9, 1, -30, -40 };
        System.out.println("The array looks like " + Arrays.toString(array));

        int maxNumberIndex = 0;
        int minNumberIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[maxNumberIndex])
                maxNumberIndex = i;

            if (array[i] < array[minNumberIndex])
                minNumberIndex = i;
        }

        System.out.println("Min number " + array[minNumberIndex]);
        System.out.println("Max number " + array[maxNumberIndex]);

        double temp = array[maxNumberIndex];
        array[maxNumberIndex] = array[minNumberIndex];
        array[minNumberIndex] = temp;

        System.out.println("After corrections the array looks like " + Arrays.toString(array));
    }
}
