import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i.
 */
class Exercise_2_1_5 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 23; i++) {
            list.add(ThreadLocalRandom.current().nextInt(-20, 30));
        }

        System.out.println("List is " + list.toString());

        System.out.print("The result list is ");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > i)
                System.out.print(list.get(i) + " ");
        }

        System.out.println();
    }
}