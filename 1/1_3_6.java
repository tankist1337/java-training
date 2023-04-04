/*
 * Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера.
 */
class Exercise_1_3_6 {
    public static void main(String[] args) {
        System.out.println("All ASCII characters: ");
        for (int i = 0; i < 128; i++) {
            System.out.println(i + "|" + (char) i);
        }
    }
}