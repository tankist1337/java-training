import java.util.Arrays;

/*
 * Дан целочисленный массив с количеством элементов п. Сжать массив, выбросив из него каждый второй 
 * элемент (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать.
 */
class Exercise_2_1_10 {
    public static void main(String[] args) {
        int[] array = new int[15];

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        System.out.println("The start array is " + Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            if ((i + 1) % 2 == 0)
                array[i] = 0;
        }

        System.out.println("The result array is " + Arrays.toString(array));
    }
}
