import java.util.Arrays;
import java.util.Random;
import java.text.DecimalFormat;

/*
 * Дан массив действительных чисел, размерность которого N. 
 * Подсчитать, сколько в нем отрицательных, положительных и нулевых элементов.
 */
class Exercise2_1_3 {
    public static void main(String[] args) {
        final int n = 16;

        double[] array = new double[n];

        // generate array of random numbers
        for (int i = 0; i < n; i++) {

            final double random = new Random().nextDouble();
            final DecimalFormat decimalFormatter = new DecimalFormat("#.####");
            final double start = -50;
            final double end = 50;
            array[i] = Double.valueOf(decimalFormatter.format(start + (random * (end - start))));
        }
        System.out.println("The array is " + Arrays.toString(array));

        int amountOfPositive = 0;
        int amountOfNegative = 0;
        int amountOfZero = 0;

        for (double d : array) {
            if (d > 0)
                amountOfPositive++;
            else if (d < 0)
                amountOfNegative++;
            else
                amountOfZero++;
        }

        System.out.printf("The amount of positive is %d\nThe amount of negative is %d\nThe amount of zero is %d\n",
                amountOfPositive,
                amountOfNegative, amountOfZero);
    }
}
