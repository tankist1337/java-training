/**
 * Напишите программу, где пользователь вводит любое целое положительное число
 * (a).
 * А программа суммирует
 * все числа от 1 до введенного пользователем числа.
 */
class Exercise_1_3_1 {
    public static void main(String[] args) {

        final InputConsoleHelper inHelper = new InputConsoleHelper.ScannerHelper();

        System.out.println("Enter a positive integer: ");
        int a = -1;
        do {

            a = inHelper.getInt();

            if (a < 0) {
                System.out.println("Integer must be a positive!");
            }
        } while (a < 0);

        inHelper.close();

        int sum = 0;

        if (a == 0)
            ;
        else {
            for (int i = 1; i < a; i++) {
                sum += i;
            }
        }

        System.out.println("The result is " + sum);
    }
}