import java.util.ArrayList;
import java.util.List;

/**
 * Задана последовательность N вещественных чисел. Вычислить сумму чисел,
 * порядковые номера которых
 * являются простыми числами (2,3,5,....).
 */
class Exercise_2_1_6 {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<Double>();

        for (double i = -10; i < 20; i += 0.5) {
            list.add(i);
        }

        System.out.println("The array is " + list.toString());

        int sum = 0;

        for (Double num : list) {
            if (isPrimeNumber(num)) {
                sum += num;
            }
        }

        System.out.println("The sum of prime numbers is " + sum);
    }

    private static boolean isPrimeNumber(Double num) {

        if (num < 2 || num.doubleValue() - (num.intValue()) != 0)
            return false;

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
