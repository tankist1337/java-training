import java.util.Scanner;

/**
 * Вычислить значение функции:
 * f(x)=
 * | x^2 - 3*x + 9, x <= 3;
 * | 1/(x^3 + 6), x > 3;
 */
class Exercise_1_2_5 {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x: ");
        final double x = scanner.nextDouble();

        scanner.close();

        final double y;

        if (x <= 3) {
            y = Math.pow(x, 2) - 3 * x + 9;
        } else {
            y = 1 / (Math.pow(x, 3) + 6);
        }

        System.out.println("The function value is " + y);

    }
}