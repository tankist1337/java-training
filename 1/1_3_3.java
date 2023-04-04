/**
 * Найти сумму квадратов первых ста чисел.
 **/
class Exercise_1_3_3 {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1; i <= 100; i++) {
            sum += Math.pow(i, 2);
        }

        System.out.println("The result is " + sum);
    }
}
