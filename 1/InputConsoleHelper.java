import java.util.Scanner;

public interface InputConsoleHelper {
    double getDouble();

    int getInt();

    void close();

    class ScannerHelper implements InputConsoleHelper {

        final Scanner scanner = new Scanner(System.in);

        public ScannerHelper() {
        }

        @Override
        public double getDouble() {

            double a = 0.0;
            do {
                if (!scanner.hasNextDouble()) {
                    System.out.println("Enter value must be double!");
                    scanner.next();
                } else {
                    a = scanner.nextDouble();
                    break;
                }
            } while (true);

            return a;
        }

        @Override
        public int getInt() {

            int a = 0;
            do {
                if (!scanner.hasNextInt()) {
                    System.out.println("Enter value must be integer!");
                    scanner.next();
                } else {
                    a = scanner.nextInt();
                    break;
                }
            } while (true);

            return a;
        }

        @Override
        public void close() {
            scanner.close();
        }
    }
}
