import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 * В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. 
 * Если таких чисел несколько, то определить наименьшее из них.
 */
class Exercise_2_1_9 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        Collections.addAll(list, -4, -3, 6, 1, 7, -2, 8, -3, 3, 1, 5, -3, -1, 7 -
                4, 0, -4, -2, 7, 2, -4, -4, -3);

        System.out.println("The array is " + list);

        HashMap<Integer, Integer> repetitions = new HashMap<Integer, Integer>();

        for (int i = 0; i < list.size(); i++) {

            if (repetitions.containsKey(list.get(i))) {
                Integer incremInteger = repetitions.get(list.get(i)) + 1;
                repetitions.put(list.get(i), incremInteger);
            } else {
                repetitions.put(list.get(i), 1);
            }
        }

        Integer maxReapetsValue = 0;
        // first loop initiates this variable because the minimum reapeatsValue in the
        // repetitions is 1, but we are have set maxReapetsValue to 0
        Integer minMaxReapetsKey = null;

        for (Integer key : repetitions.keySet()) {

            if (repetitions.get(key) > maxReapetsValue) {
                minMaxReapetsKey = key;
                maxReapetsValue = repetitions.get(key);
            } else if (repetitions.get(key) == maxReapetsValue) {
                if (key < minMaxReapetsKey) {
                    minMaxReapetsKey = key;
                }
            }
        }

        System.out.println(
                "The minimum key (" + minMaxReapetsKey + ") with the maximum repeats (" + maxReapetsValue + ")");
    }
}