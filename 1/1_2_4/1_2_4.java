import java.util.Arrays;

/**
 * 4. Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича.
 * Определить, пройдет ли кирпич через
 * отверстие.
 */
class Exercise_1_2_4 {
    public static void main(String[] args) {

        final double holeHeight = 15;
        final double holeWidth = 8;

        final double brickHeight = 20;
        final double brickWidth = 15.1;
        final double brickLength = 3;

        double[] shapeSizes = { brickHeight, brickLength, brickWidth };
        double[] holeSizes = { holeHeight, holeWidth };

        System.out.println(isGoesThrough(shapeSizes, holeSizes));
    }

    // todo: create class Pusher who will select a strategy depending on the object
    // and the hole
    private static boolean isGoesThrough(double[] shapeSizes,
            double[] holeSizes) {
        // First you need to compile both lists of lengths. It is necessary to
        // immediately weed out the longest side of the brick and work with the 2
        // smallest.
        Arrays.sort(shapeSizes);
        Arrays.sort(holeSizes);

        // Compare 2 short sides of brick with hole size
        if (shapeSizes[0] <= holeSizes[0] && shapeSizes[1] <= holeSizes[1]) {
            return true;
        }
        // Checking to see if a brick can pass diagonally
        else {
            // Find the hole diagonal by the Pythagorean theorem
            double holeDiagonal = Math.sqrt(Math.pow(holeSizes[0], 2) + Math.pow(holeSizes[1], 2));

            //
            if (holeDiagonal <= shapeSizes[0]) {
                return false;
            } else {

                // Find the angle by the cosine theorem
                final double angleC = Math.toDegrees(Math.acos((Math.pow(holeDiagonal, 2) + Math.pow(holeSizes[0], 2)
                        - Math.pow(holeSizes[1], 2)) / (2 * holeSizes[0] * holeDiagonal)));

                // Find the third angle of triangle
                final double angleB = 180 - 90 - angleC;

                // B side is as short as possible from the side of the brick, which is placed in
                // the hole, to the corner of the hole
                // Find it by the Sinus theorem
                double sideB = shapeSizes[0] / 2.0 * Math.sin(Math.toRadians(angleB))
                        / Math.sin(Math.toRadians(angleC));

                double maxAvailableDiagonal = holeDiagonal - 2 * sideB;

                System.out.println(maxAvailableDiagonal);

                return shapeSizes[1] <= maxAvailableDiagonal;
            }
        }
    }
}
