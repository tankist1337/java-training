import java.util.Hashtable;

/**
 * Вычислить значения функции на отрезке [а,b] c шагом h:
 * y =
 * | { x, x > 2
 * | { -x, x <= 2
 */
class Exercise_1_3_2 {
    public static void main(String[] args) {
        final InputConsoleHelper input = new InputConsoleHelper.ScannerHelper();

        double a;
        double b;

        do {
            System.out.println("Enter a: ");
            a = input.getDouble();

            System.out.println("Enter b: ");
            b = input.getDouble();

            if (a > b)
                System.out.println("a must be more then b!");
        } while (a > b);

        double h;

        do {
            System.out.println("Enter h: ");
            h = input.getDouble();

            if (h <= 0)
                System.out.println("h must be more then 0!");
        } while (h <= 0);

        input.close();

        // data structure of [x,y]
        Hashtable<Double, Double> values = new Hashtable<Double, Double>();

        for (double i = a; i <= b; i += h) {
            if (i > 2) {
                values.put(i, i);
            } else {
                values.put(i, -i);
            }
        }

        // Output result
        for (double i = a; i <= b; i += h) {
            System.out.println("[" + i + "," + values.get(i) + "]");
        }
    }
}