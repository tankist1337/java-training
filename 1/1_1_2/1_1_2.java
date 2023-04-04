import java.util.Scanner;

class Exercise_1_1_2 {
    public static void main(String[] args) {
        System.out.println("z = (b+sqrt(b^2 + 4*a*c))/2*a - a^3*c + b^-2");

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a: ");
        final double a = input.nextDouble();
        System.out.print("Enter b: ");
        final double b = input.nextDouble();
        System.out.print("Enter c: ");
        final double c = input.nextDouble();

        input.close();

        final double resultUnderSqrt = Math.pow(b, 2) + 4 * a * c;

        if (a == 0) {
            System.out.println("You can’t divide by zero, so the a shouldn’t be 0");
        } else if (b == 0) {
            System.out.println("You can’t divide by zero, so the b shouldn’t be 0");
        } else if (resultUnderSqrt < 0) {
            System.out.println("Root from minus number not calculated");
        } else {
            final double z = (b + Math.sqrt(Math.pow(b, 2) + 4 * a * c)) / (2 * a) - Math.pow(a, 3) * c
                    + Math.pow(b, -2);
            System.out.println(String.format("The z is %f", z));
        }
    }
}
