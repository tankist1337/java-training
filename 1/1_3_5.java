/*
 * Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых больше или равен 
 * заданному е. Общий член ряда имеет вид:
 * an = 1/(2^n) + 1/(3^n)
 */
class Exercise_1_3_5 {
    public static void main(String[] args) {
        final InputConsoleHelper iHelper = new InputConsoleHelper.ScannerHelper();

        // series's indexes from n to k
        int n, k;

        do {

            System.out.println("Enter start n (integer):");
            n = iHelper.getInt();

            System.out.println("Enter start k (integer):");
            k = iHelper.getInt();

            if (k <= n)
                System.out.println("k must be more than n!");

        } while (k <= n);

        System.out.println("Enter e (double): ");
        final double e = iHelper.getDouble();

        iHelper.close();

        // k - n + 1 because for example we have from 2 to 5 series [2,3,4,5] then count
        // it 5 - 2 + 1 = 4
        Double[] series = new Double[k - n + 1];

        for (int i = 0; i < series.length; i++) {
            int indexOfSerie = n + i;
            series[i] = 1 / (Math.pow(2, indexOfSerie)) + 1 / (Math.pow(3, n + i));
        }

        double sum = 0;

        for (Double number : series) {
            if (Math.abs(number) >= e)
                sum += number;
        }

        System.out.println("The result is " + sum);
    }
}
