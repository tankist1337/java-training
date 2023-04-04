import java.util.Scanner;

/**
 * 
 * Вычислить значение выражения по формуле (все переменные принимают
 * действительные значения):
 * (sinx + cosy) / (cosx - siny) * tg(x*y)
 *
 */
class Exercise_1_1_3 {
    public static void main(String[] args) {
        System.out.println("Solve: (sinX + cosY)/(cosX - sinY) * tg(X*Y)");

        final Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x in degree: ");
        final double xInDegrees = scanner.nextDouble();
        final double xInRadians = Math.toRadians(xInDegrees);

        System.out.print("Enter y in degree: ");
        final double yInDegrees = scanner.nextDouble();
        final double yInRadians = Math.toRadians(yInDegrees);

        scanner.close();

        final double denominator = Math.cos(xInRadians) - Math.sin(yInRadians);

        final double productOfXy = xInDegrees * yInDegrees;

        // Need a decimal of product of x and y divided by 360
        final double multipliedBy360 = productOfXy / 360.0d;
        final int multipliedBy360AsInt = (int) multipliedBy360;
        final double decimalOfMultiplied = multipliedBy360 - multipliedBy360AsInt;

        if ((Math.abs(denominator)) < 0.00000000001d) {
            System.out.println("Denominator must not be 0");
        } else if (decimalOfMultiplied * 360 == 90 || decimalOfMultiplied * 360 == 270) {
            System.out.println("Tangents for 90 and 270 degrees undefined");
        } else {
            final double result = (Math.sin(xInRadians) + Math.cos(yInRadians))
                    / (Math.cos(xInRadians) - Math.sin(yInRadians))
                    * Math.tan(productOfXy);
            System.out.println("The result of math problem is " + result);
        }
    }
}
