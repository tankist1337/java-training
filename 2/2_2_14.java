import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число
 * единиц равно номеру столбца.
 */
class Exercise_2_2_14 {
    public static void main(String[] args) {

        final int rowCount = 6;
        final int columnCount = 6;

        final List<List<Integer>> matrix = IntStream.range(0, rowCount)
                .mapToObj(i -> new ArrayList<Integer>(Collections.nCopies(columnCount, 0)))
                .collect(Collectors.toList());

        if (columnCount > rowCount) {
            System.out.println("Row count must be equal or more then column count because of the problem condition!");
        } else {
            for (int c = 0; c < columnCount; ++c) {
                final List<Integer> range = IntStream.rangeClosed(0, rowCount - 1)
                        .boxed().collect(Collectors.toList());

                final Random random = new Random();

                for (int i = 0; i < c + 1; ++i) {
                    int randomIndex = random.nextInt(range.size());
                    randomIndex = range.get(randomIndex);

                    matrix.get(randomIndex).set(c, 1);

                    range.remove(Integer.valueOf(randomIndex));
                }
            }

            final MatrixPrinter printer = new MatrixPrinter.ConsoleMatrixPrinter();
            System.out.println("The finish matrix: ");
            printer.print(matrix);
        }

    }
}
