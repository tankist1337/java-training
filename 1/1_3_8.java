import java.util.HashSet;
import java.util.Set;

/*
 * Даны два числа. Определить цифры, входящие в запись как первого так и второго числа.
 */
class Exercise_1_3_8 {
    public static void main(String[] args) {
        final int number1 = 10523;
        final long number2 = 556900790000033003L;

        Set<Character> uniqueDigitals1 = new HashSet<Character>();
        Set<Character> uniqueDigitals2 = new HashSet<Character>();

        convertIntToCharacterSet(number1, uniqueDigitals1);

        convertIntToCharacterSet(number2, uniqueDigitals2);

        System.out.print("The same digitals of " + number1 + " and " + number2 + ": ");
        for (char c : uniqueDigitals1) {
            if (uniqueDigitals2.contains(c)) {
                System.out.print(c + " ");
            }
        }
        System.out.println();
    }

    private static void convertIntToCharacterSet(final Number number, Set<Character> set) {
        for (char c : String.valueOf(number).toCharArray()) {
            set.add(c);
        }
    }
}
