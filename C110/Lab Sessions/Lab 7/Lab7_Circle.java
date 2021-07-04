import java.awt.*;

public class Lab7_Circle extends Lab7_Shape {

    private double radius;

    public Lab7_Circle() {
    }

    public Lab7_Circle(double x, double y, double radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    double computeArea() {
        return radius * radius * Math.PI;
    }

    void draw() {
        String area = String.format("%.2f", computeArea());
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(x, y, radius);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(x, y, area);
        StdDraw.circle(x, y, radius);
    }

}
