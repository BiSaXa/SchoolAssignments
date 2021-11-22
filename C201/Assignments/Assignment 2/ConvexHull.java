import java.util.ArrayList;

public class ConvexHull {

    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<>();
        StdDraw.setCanvasSize(600, 600);
        StdDraw.setScale(0, 1);
        initialize(points);
    }

    private static void initialize(ArrayList<Point> points) {
        while (true) {
            if (StdDraw.isMousePressed()) {
                double mX = StdDraw.mouseX();
                double mY = StdDraw.mouseY();
                if (Point.onPoint(mX, mY, points) == -1 && points.size() != 0) {
                    Point p = new Point(mX, mY);
                    p.drawPoint();
                    points.add(p);
                    StdDraw.pause(500);
                } else if (Point.onPoint(mX, mY, points) != -1) {
                    points.remove(Point.onPoint(mX, mY, points));
                    StdDraw.clear();
                    for (Point point : points) {
                        point.drawPoint();
                    }
                    StdDraw.pause(500);
                } else if (points.size() == 0) {
                    Point p = new Point(mX, mY);
                    p.drawPoint();
                    points.add(p);
                    StdDraw.pause(500);
                } else {
                    System.out.println("An error occured in point system.");
                    System.exit(1);
                }
                if (points.size() >= 3) {
                    Point h0 = Point.getRightmostLowestPoint(points);
                    ArrayList<Point> hull = new ArrayList<>();
                    hull.add(h0);
                    Point t0 = h0;
                    while (true) {
                        Point t1 = points.get(0);
                        for (int i = 1; i < points.size(); i++) {
                            double status = Point.whichSide(t0.getX(), t1.getX(), points.get(i).getX(), t0.getY(), t1.getY(), points.get(i).getY());
                            if (status > 0) {
                                t1 = points.get(i);
                            } else if (status == 0) {
                                if (Point.distance(points.get(i).getX(), t0.getX(), points.get(i).getY(), t0.getY()) > Point.distance(t1.getX(), t0.getX(), t1.getY(), t0.getY())) {
                                    t1 = points.get(i);
                                }
                            }
                        }
                        if (t1.getX() == h0.getX() && t1.getY() == h0.getY()) {
                            break;
                        } else {
                            hull.add(t1);
                            t0 = t1;
                        }
                    }
                    StdDraw.clear();
                    for (Point point : points) {
                        point.drawPoint();
                    }
                    for (int p = 0; p < hull.size(); p++) {
                        if (p != hull.size() - 1) {
                            hull.get(p).drawLine(hull.get(p + 1));
                        } else {
                            hull.get(p).drawLine(hull.get(0));
                        }
                    }
                } else {
                    StdDraw.clear();
                    for (Point point : points) {
                        point.drawPoint();
                    }
                }
            }
        }
    }

}

class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void drawPoint() {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(x, y, 0.01);
    }

    public void drawLine(Point anotherPoint) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(this.x, this.y, anotherPoint.getX(), anotherPoint.getY());
    }

    public static Point getRightmostLowestPoint(ArrayList<Point> points) {
        int rightmostIndex = 0;
        double rightmostX = points.get(0).getX();
        double rightmostY = points.get(0).getY();
        for (int i = 1; i < points.size(); i++) {
            if (rightmostY < points.get(i).getY()) {
                rightmostX = points.get(i).getX();
                rightmostY = points.get(i).getY();
                rightmostIndex = i;
            } else if (rightmostY == points.get(i).getY() && rightmostX < points.get(i).getX()) {
                rightmostX = points.get(i).getX();
                rightmostIndex = i;
            }
        }
        return points.get(rightmostIndex);
    }

    public static double distance(double x1, double x2, double y1, double y2) {
        return Math.sqrt((Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2)));
    }

    public static double whichSide(double x0, double x1, double x2, double y0, double y1, double y2) {
        return (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
    }

    public static int onPoint(double mX, double mY, ArrayList<Point> points) {
        int collidedPointIndex = -1;
        for (int i = 0; i < points.size(); i++) {
            if (distance(mX, points.get(i).getX(), mY, points.get(i).getY()) <= 0.01) {
                collidedPointIndex = i;
            }
        }
        return collidedPointIndex;
    }

}