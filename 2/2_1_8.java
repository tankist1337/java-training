import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/*
 * Дана последовательность целых чисел a1 , a2 , ... , an . 
 * Образовать новую последовательность, выбросив из исходной те члены, которые равны min( a1 , a2 , .. , an ) .
 */
class Exercise_2_1_8 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        Collections.addAll(list, -4, -3, 6, 1, 7, -2, 8, 3, 1, 5, -3, -1, 7 -
                4, 0, -4, -2, 7, 2, -4, -4);

        System.out.println("The array is \t\t\t\t" + list.toString());

        int minValue = list.get(0);

        for (int i = 0; i < list.size(); i++) {
            if (minValue > list.get(i))
                minValue = list.get(i);
        }

        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
            Integer number = iterator.next();
            if (Objects.equals(number, minValue)) {
                iterator.remove();
            }
        }

        System.out.println("Now the array after all removings is \t" + list.toString());

    }
}
