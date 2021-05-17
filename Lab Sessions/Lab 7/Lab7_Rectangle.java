import java.awt.*;

public class Lab7_Rectangle extends Lab7_Shape {

    private double width;
    private double height;

    public Lab7_Rectangle() {
    }

    public Lab7_Rectangle(double x, double y, double width, double height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    double computeArea() {
        return width * height;
    }

    void draw() {
        String area = String.format("%.2f", computeArea());
        StdDraw.setPenColor(color);
        StdDraw.filledRectangle(x, y, width / 2, height / 2);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(x, y, area);
        StdDraw.rectangle(x, y, width / 2, height / 2);
    }

}
