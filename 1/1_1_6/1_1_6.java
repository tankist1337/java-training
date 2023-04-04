import java.util.ArrayList;
import java.util.List;

/**
 * 6. Для данной области составить линейную программу, которая печатает true,
 * если точка с координатами (х, у)
 * принадлежит закрашенной области, и false — в противном случае:
 * 
 * закрашенная область -
 * 1. по x от -2 до 2, по y от 0 до 4
 * 2. по x от -4 до 4, по y от -3 до 0
 */
class Exercise_1_1_6 {
    public static void main(String[] args) {
        final List<Shape> filledArea = new ArrayList<Shape>();
        filledArea.add(new Rectangle(new Point(-2, 0), new Point(2, 4)));
        filledArea.add(new Rectangle(new Point(-4, -3), new Point(4, 0)));

        final MultiShape multiShape = new MultiShape(filledArea);

        // is given in the condition
        final Point point = new Point(0, 4.00);

        System.out.println(String.format("point(%f,%f) belong to filled area: %b", point.x, point.y,
                multiShape.isPointBelonged(point)));
    }
}

interface Shape {
    boolean isPointBelonged(Point point);
}

class MultiShape implements Shape {

    final List<Shape> shapes;

    public MultiShape(List<Shape> shapes) {
        this.shapes = shapes;
    }

    @Override
    public boolean isPointBelonged(Point point) {
        boolean isPointBelonged = false;

        for (Shape shape : shapes) {
            if (shape.isPointBelonged(point)) {
                isPointBelonged = true;
                break;
            }
        }

        return isPointBelonged;
    }

}

class Rectangle implements Shape {

    private final Point startPoint;
    private final Point endPoint;

    // startPoint always have minimal x and y
    Rectangle(Point startPoint, Point endPoint) {
        final double minX;
        final double maxX;

        if (startPoint.x > endPoint.x) {
            minX = endPoint.x;
            maxX = startPoint.x;
        } else {
            minX = startPoint.x;
            maxX = endPoint.x;
        }

        final double minY;
        final double maxY;

        if (startPoint.y > endPoint.y) {
            minY = endPoint.y;
            maxY = startPoint.y;
        } else {
            minY = startPoint.y;
            maxY = endPoint.y;
        }

        this.startPoint = new Point(minX, minY);
        this.endPoint = new Point(maxX, maxY);
    }

    @Override
    public boolean isPointBelonged(Point point) {
        return point.x >= startPoint.x && point.x <= endPoint.x && point.y >= startPoint.y && point.y <= endPoint.y;

    }
}

class Point {

    final double x;
    final double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
