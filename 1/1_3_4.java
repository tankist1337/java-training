import java.math.BigInteger;

/**
 * Составить программу нахождения произведения квадратов первых двухсот чисел.
 */
class Exercise_1_3_4 {
    public static void main(String[] args) {
        BigInteger product = BigInteger.ONE;

        for (long i = 1; i <= 200; i++) {
            product = product.multiply(BigInteger.valueOf(i * i));
        }

        System.out.println("The result is " + product);
    }
}
