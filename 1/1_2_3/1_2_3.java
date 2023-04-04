class Exercise_1_2_3 {
    public static void main(String[] args) {

        final Point point1 = new Point(1, 1);
        final Point point2 = new Point(0, 0);

        final Point point3 = new Point(-2, -1);

        double x = point3.x;
        double y;

        y = (x - point1.x) * (point2.y - point1.y) / (point2.x - point1.x) + point1.y;

        System.out.println("3 points lie on the same line: " + (y == point3.y));
    }
}

class Point {

    final double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}