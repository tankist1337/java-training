import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Exercise_1_1_1 {
    public static void main(String[] args) throws IOException {
        System.out.println("z = ((a - 3) * b / 2) + c");

        System.out.print("a = ");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        final int a = Integer.parseInt(reader.readLine());

        System.out.print("b = ");
        final int b = Integer.parseInt(reader.readLine());

        System.out.print("c = ");
        final int c = Integer.parseInt(reader.readLine());

        final int z = ((a - 3) * b / 2) + c;
        final String outputString = String.format("z = %d", z);

        System.out.println(outputString);
    }
}