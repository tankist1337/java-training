/*
 * Для каждого натурального числа в промежутке от m до n вывести все делители, 
 * кроме единицы и самого числа. m и n вводятся с клавиатуры.
 */
class Exercise_1_3_7 {
    public static void main(String[] args) {
        System.out.println("natural numbers from m to n");

        final InputConsoleHelper iHelper = new InputConsoleHelper.ScannerHelper();

        int m, n;

        do {

            System.out.print("Enter m: ");
            m = iHelper.getInt();

            System.out.print("Enter n: ");
            n = iHelper.getInt();

            if (m >= n)
                System.out.println("n must be more than m!");
        } while (m >= n);

        iHelper.close();

        System.out.println("Number\t| Dividers");
        for (int i = m; i <= n; i++) {
            System.out.print(i + "\t| ");
            for (int j = 2; j < i; j++) {
                if (i % j == 0)
                    System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}