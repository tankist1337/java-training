import java.util.Scanner;

/**
 * 2. Найти max{min(a, b), min(c, d)}.
 */

class Exercise_1_2_2 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a: ");
        final double a = scanner.nextDouble();
        System.out.print("Enter b: ");
        final double b = scanner.nextDouble();
        System.out.print("Enter c: ");
        final double c = scanner.nextDouble();
        System.out.print("Enter d: ");
        final double d = scanner.nextDouble();

        scanner.close();

        System.out.println("max{min(a, b), min(c, d)}:" + Math.max(Math.min(a, b), Math.min(c, d)));

    }
}