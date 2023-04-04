import java.util.Scanner;

/**
 * 1. Даны два угла треугольника (в градусах). Определить, существует ли такой
 * треугольник, и если да, то будет ли
 * он прямоугольным.
 */

class Exercise_1_2_1 {
    public static void main(String[] args) {
        /**
         * 1. An angle cannot be equal to or greater than 180 degrees and cannot be
         * equal to or less then 0 degrees
         * 2. Sum of angles must be 180
         */

        final Scanner scanner = new Scanner(System.in);

        // These angles must be in degrees
        System.out.print("Enter the first angle of triangle: ");
        final double firstAngle = scanner.nextDouble();
        System.out.print("Enter the second angle: ");
        final double secondAngle = scanner.nextDouble();

        scanner.close();

        if (firstAngle <= 0 || secondAngle <= 0) {
            System.out.println("The angles cannot be equal to or less then 0 degrees");
        } else {
            final double thirdAngle = 180 - firstAngle - secondAngle;

            if (thirdAngle <= 0) {
                System.out.println("The triangle cannot exist");
            } else {

                if (firstAngle == 90 || secondAngle == 90 || thirdAngle == 90) {
                    System.out.println("This triangle is rectangular");
                } else {
                    System.out.println("This triangle is not rectangular");
                }
            }
        }
    }
}