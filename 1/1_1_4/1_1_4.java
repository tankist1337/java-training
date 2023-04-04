/**
 * 4. Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и
 * целой частях). Поменять местами
 * дробную и целую части числа и вывести полученное значение числа.
 */

class Exercise_1_1_4 {
    public static void main(String[] args) {
        final double r = 999.111;

        System.out.println("Before: " + r);

        final String doubleAsString = String.valueOf(r);

        final int indexOfDecimal = doubleAsString.indexOf(".");

        final String resultAString = doubleAsString.substring(indexOfDecimal + 1) + "."
                + doubleAsString.substring(0, indexOfDecimal);

        System.out.println("After: " + resultAString);

    }
}
