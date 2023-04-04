/**
 * В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые
 * кратны данному К.
 */
class Exercise_2_1_1 {
    public static void main(String[] args) {
        int[] intArray = new int[] { 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
                27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50 };

        final int k = 13;

        int sum = 0;

        for (int i : intArray) {
            if (i % k == 0)
                sum += i;
        }

        System.out.println("The result is " + sum);
    }
}