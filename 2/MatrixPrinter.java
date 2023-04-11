import java.util.List;

public interface MatrixPrinter {
    public <T> void print(List<List<T>> matrix);

    class ConsoleMatrixPrinter implements MatrixPrinter {

        @Override
        public <T> void print(List<List<T>> matrix) {
            for (List<T> row : matrix) {
                System.out.println(row.toString());
            }
        }
    }
}
