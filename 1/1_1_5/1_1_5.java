
/**
 * Дано натуральное число Т, которое представляет длительность прошедшего
 * времени в секундах. Вывести
 * данное значение длительности в часах, минутах и секундах в следующей форме:
 * ННч ММмин SSc.
 */
class Exercise_1_1_5 {
    public static void main(String[] args) {
        final int t = 3736;

        final int seconds = t % 60;
        final int hours = t / 3600;
        final int minutes = (t % 3600) / 60;

        String result = String.format("Result is %02dч %02dм %02dс", hours, minutes,
                seconds);
        System.out.println(result);
    }
}
