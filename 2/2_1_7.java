import java.util.ArrayList;
import java.util.List;

/*
 * Даны действительные числа a1 , a2 , ... , an . 
 * Найти max( a1 + a2n , a2 + a2n−1 , ... , an + an + 1 ) .
 * 
 * !!!!!! Вообще индекс n + 1 выходит за пределы, из-за этого последнее вычисление выполнить невозможно
 * !!!!!! Я не буду выполнять те операции, где индекс выходит за границы
 * !!!!!! 2n - index of outside
 * !!!!!! 2n - index of outside
 */
class Exercise_2_1_7 {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<Double>();

        for (double i = -10; i < 25; i++) {
            list.add(i);
        }

        int maxIndex = 0;

    }
}
