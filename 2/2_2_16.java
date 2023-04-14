import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Магическим квадратом порядка n называется квадратная матрица размера nxn,
 * составленная из чисел 1, 2, 3, ..., n 2 так, что суммы по каждому столбцу, 
 * каждой строке и каждой из двух больших диагоналей равны между собой. 
 * Построить такой квадрат. 
 * 
 * Пример магического квадрата порядка 3:
 * 6 1 8
 * 7 5 3
 * 2 9 4
 */
class Exercise_2_2_16 {
    public static void main(String[] args) throws Exception {
        final MagicSquareFactory factory = new MagicSquareFactoryImpl();
        final int order = Integer.parseInt(args[0]);
        final MagicSquare magicSquare = factory.createOrdinaryMagicSquare(order);

        final List<List<Integer>> matrix = magicSquare.generate();

        System.out.println("The magic square: ");
        final MatrixPrinter printer = new MatrixPrinter.ConsoleMatrixPrinter();
        printer.print(matrix);

    }
}

interface MagicSquareFactory {
    public MagicSquare createOrdinaryMagicSquare(final int order) throws Exception;
}

class MagicSquareFactoryImpl implements MagicSquareFactory {

    @Override
    public MagicSquare createOrdinaryMagicSquare(final int order) throws Exception {
        if (order == 0) {
            throw new Exception("Order must not be zero!");
        }
        // order is 1
        else if (order == 1) {
            return new OneMagicSquare(order);
        }
        // order is 2
        else if (order == 2) {
            throw new Exception("Order must not be two!");
        }
        // order is odd number
        else if ((order + 1) % 2 == 0) {
            return new OddMagicSquare(order);
        }
        // even numbers fall into 4n and 4n+2
        // order is 4n
        else if (order % 4 == 0) {
            return new FourNMagicSquare(order);
        }
        // order is 4n + 2
        else if ((order - 2) % 4 == 0) {
            return new FourNPlusTwoMagicSquare(order);
        } else {
            throw new Exception("Order is invalid!");
        }
    }

}

abstract class MagicSquare {
    protected int order;

    public MagicSquare(int order) {
        this.order = order;
    }

    public abstract List<List<Integer>> generate();
}

class OddMagicSquare extends MagicSquare {

    public OddMagicSquare(int order) {
        super(order);
    }

    @Override
    public List<List<Integer>> generate() {
        final List<List<Integer>> matrix = new ArrayList<List<Integer>>();

        for (int r = 0; r < order; r++) {
            matrix.add(new ArrayList<Integer>());
            for (int c = 0; c < order; c++) {
                matrix.get(r).add(0);
            }
        }

        final SiameseMethodFiller filler = new SiameseMethodFillerImpl();

        filler.fill(matrix);

        return matrix;
    }

}

class FourNMagicSquare extends MagicSquare {

    public FourNMagicSquare(int order) {
        super(order);
    }

    @Override
    // Magic Squares of Order 4n
    // https://www.math.wichita.edu/~richardson/mathematics/magic%20squares/order4nmagicsquares.html
    //
    // We proceed as we did in the 44 case, but this time we will be using all the
    // positive integers from 1 to 64.
    // We start in the upper left-hand corner to put numbers in the cells.
    // As before, we will only put the cell number in the cell if the cell is blank;
    // that is, does not have a diagonal line in it.
    // We continue this process until we reach the lower right-hand corner.
    //
    // * 2 3 * * 6 7 *
    // 9 * * 12 13 * * 16
    // 17 * * 20 21 * * 24
    // * 26 27 * * 30 31 *
    // * 34 35 * * 38 39 *
    // 41 * * 44 45 * * 48
    // 49 * * 52 53 * * 56
    // * 58 59 * * 62 63 *
    //
    // Now we begin in the lower right-hand corner and work our way back using the
    // numbers 1,4,5,8,10,11,... and 64.
    // We put these number in the cells which originally had the diagonal lines
    // starting with 1 in the lower right-hand corner.
    // Our finished product looks like this:
    //
    // [64, 2, 3, 61, 60, 6, 7, 57]
    // [9, 55, 54, 12, 13, 51, 50, 16]
    // [17, 47, 46, 20, 21, 43, 42, 24]
    // [40, 26, 27, 37, 36, 30, 31, 33]
    // [32, 34, 35, 29, 28, 38, 39, 25]
    // [41, 23, 22, 44, 45, 19, 18, 48]
    // [49, 15, 14, 52, 53, 11, 10, 56]
    // [8, 58, 59, 5, 4, 62, 63, 1]

    public List<List<Integer>> generate() {
        final List<List<Integer>> matrix = new ArrayList<List<Integer>>();

        for (int r = 0; r < order; r++) {
            matrix.add(new ArrayList<Integer>());
            for (int c = 0; c < order; c++) {
                matrix.get(r).add(0);
            }
        }

        int counter = 1;
        final int quadOrder = order * order;
        for (int r = 0; r < order; r++) {
            if (r % 4 == 0 || r % 4 == 3) {
                for (int c = 0; c < order; c++) {
                    if (c % 4 == 0 || c % 4 == 3) {
                        matrix.get(r).set(c, quadOrder - counter + 1);
                    } else {
                        matrix.get(r).set(c, counter);
                    }

                    ++counter;
                }
            } else {
                for (int c = 0; c < order; c++) {
                    if (c % 4 == 1 || c % 4 == 2) {
                        matrix.get(r).set(c, quadOrder - counter + 1);
                    } else {
                        matrix.get(r).set(c, counter);
                    }

                    ++counter;
                }
            }

        }

        return matrix;
    }

}

class FourNPlusTwoMagicSquare extends MagicSquare {

    public FourNPlusTwoMagicSquare(int order) {
        super(order);
    }

    @Override
    // Magic Squares of Even Order (4n + 2)
    // https://www.math.wichita.edu/~richardson/mathematics/magic%20squares/even-ordermagicsquares.html
    public List<List<Integer>> generate() {
        final List<List<Integer>> matrix = new ArrayList<List<Integer>>();

        for (int r = 0; r < order; r++) {
            matrix.add(new ArrayList<Integer>());
            for (int c = 0; c < order; c++) {
                matrix.get(r).add(0);
            }
        }

        final SiameseMethodFiller filler = new SiameseMethodFillerImpl();

        // First we partition the 6x6 matrix into four 3x3 blocks. In the upper
        // left-hand
        // block we enter the numbers 1,2,3,...,9 by the Siam method. We then enter the
        // numbers 10,11,12,...,18, using the Siam method, in
        // the lower right-hand block. Next we enter the numbers 19,20,21,...,27 in the
        // same way in the upper right-hand block. Finally, we enter the numbers
        // 28,29,30,...,36 in the lower left-hand block, getting the square at right in
        // the figure below.
        for (int i = 0; i < 4; i++) {
            List<List<Integer>> quarterMatrix = new ArrayList<List<Integer>>();

            for (int r = 0; r < order / 2; r++) {
                quarterMatrix.add(new ArrayList<Integer>());
                for (int c = 0; c < order / 2; c++) {
                    quarterMatrix.get(r).add(0);
                }
            }

            filler.fill(quarterMatrix, i * order * order / 4 + 1);

            switch (i) {
                // top left quarter of the matrix
                case 0:
                    for (int r = 0; r < quarterMatrix.size(); r++) {
                        for (int c = 0; c < quarterMatrix.size(); c++) {
                            matrix.get(r).set(c, quarterMatrix.get(r).get(c));
                        }
                    }

                    break;
                // bottom right quarter of the matrix
                case 1:
                    for (int r = 0; r < quarterMatrix.size(); r++) {
                        for (int c = 0; c < quarterMatrix.size(); c++) {
                            matrix.get(r + order / 2).set(c + order / 2, quarterMatrix.get(r).get(c));
                        }
                    }

                    break;
                // top right quarter of the matrix
                case 2:
                    for (int r = 0; r < quarterMatrix.size(); r++) {
                        for (int c = 0; c < quarterMatrix.size(); c++) {
                            matrix.get(r).set(c + order / 2, quarterMatrix.get(r).get(c));
                        }
                    }

                    break;
                // bottom left quarter of the matrix
                case 3:
                    for (int r = 0; r < quarterMatrix.size(); r++) {
                        for (int c = 0; c < quarterMatrix.size(); c++) {
                            matrix.get(r + order / 2).set(c, quarterMatrix.get(r).get(c));
                        }
                    }

                    break;
            }
        }

        // swap rows [1,order/2] for [order/2,order] on the the left columns
        for (int c = 0; c < (order - 2) / 4; c++) {
            final int[] temporaryColumn = new int[order / 2];

            for (int r = 0; r < order / 2; r++) {
                temporaryColumn[r] = matrix.get(r).get(c);
                matrix.get(r).set(c, matrix.get(r + order / 2).get(c));
                matrix.get(r + order / 2).set(c, temporaryColumn[r]);
            }
        }

        // swap rows [1,order/2] for [order/2,order] on the the right columns
        for (int c = 0; c < (order - 2) / 4 - 1; c++) {
            final int[] temporaryColumn = new int[order / 2];

            for (int r = 0; r < order / 2; r++) {
                temporaryColumn[r] = matrix.get(r).get(order - 1 - c);
            }

            for (int r = 0; r < order / 2; r++) {
                matrix.get(r).set(order - 1 - c, matrix.get(r + order / 2).get(order - 1 - c));
                matrix.get(r + order / 2).set(order - 1 - c, temporaryColumn[r]);
            }
        }

        // swap the center and left element of the top left quarter for the center and
        // left
        // element of the bottom left quarter
        final int centerLeftColumn = (int) (order / 2d / 2d);
        final int centerTopLeftRow = (int) (order / 2d / 2d);
        final int centerBottomLeftRow = centerTopLeftRow + order / 2;

        for (int i = 0; i < 2; i++) {
            int temporary = matrix.get(centerTopLeftRow).get(centerLeftColumn - i);
            matrix.get(centerTopLeftRow).set(centerLeftColumn - i,
                    matrix.get(centerBottomLeftRow).get(centerLeftColumn - i));
            matrix.get(centerBottomLeftRow).set(centerLeftColumn - i, temporary);
        }

        return matrix;
    }

}

class OneMagicSquare extends MagicSquare {

    public OneMagicSquare(int order) {
        super(order);
    }

    @Override
    public List<List<Integer>> generate() {
        return new ArrayList<List<Integer>>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(order)));
            }
        };
    }

}

interface SiameseMethodHelper {

    public int getTopIndexFrom(int row, int order);

    public int getBottomIndexFrom(int row, int order);

    public int getRightIndexFrom(int column, int order);
}

class SiameseMethodHelperImpl implements SiameseMethodHelper {

    @Override
    public int getTopIndexFrom(int row, int order) {
        return row - 1 < 0 ? order - row - 1 : row - 1;
    }

    @Override
    public int getBottomIndexFrom(int row, int order) {
        return row + 1 >= order ? row + 1 - order : row + 1;
    }

    @Override
    public int getRightIndexFrom(int column, int order) {
        return column + 1 >= order ? column + 1 - order : column + 1;
    }
}

interface SiameseMethodFiller {
    public boolean fill(List<List<Integer>> matrix, int startCounter);

    public boolean fill(List<List<Integer>> matrix);
}

class SiameseMethodFillerImpl implements SiameseMethodFiller {

    @Override
    public boolean fill(List<List<Integer>> matrix) {
        return fill(matrix, 1);
    }

    @Override
    // Siames method
    // https://en.wikipedia.org/wiki/Siamese_method#:~:text=The%20Siamese%20method%2C%20or%20De,columns%20and%20diagonals%20are%20identical).
    public boolean fill(final List<List<Integer>> matrix, final int startCounter) {

        final int order = matrix.size();

        final SiameseMethodHelper helper = new SiameseMethodHelperImpl();

        int row = 0;
        int column = (int) order / 2; // center of the odd order matrix
        int counter = startCounter;

        matrix.get(0).set(column, counter);
        matrix.get(order - 1).set(column, order * order + counter - 1);

        ++counter;

        while (true) {
            final int topRow = helper.getTopIndexFrom(row, order);
            final int rightColumn = helper.getRightIndexFrom(column, order);

            if (matrix.get(topRow).get(rightColumn).equals(0)) {

                row = topRow;
                column = rightColumn;
                matrix.get(row).set(column, counter);

                counter++;

            } else {
                final int bottomRow = helper.getBottomIndexFrom(row, order);

                if (matrix.get(bottomRow).get(column).equals(0)) {
                    row = bottomRow;
                    matrix.get(row).set(column, counter);

                    counter++;
                } else {
                    break;
                }
            }
        }

        return true;
    }
}