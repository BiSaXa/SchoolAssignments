import java.util.ArrayList;
import java.util.Random;

public class Lab7 {

    public static void main(String[] args) {
        Random randomGenerator = new Random();
        ArrayList<Lab7_Circle> circles = new ArrayList<>();
        ArrayList<Lab7_Rectangle> rectangles = new ArrayList<>();
        StdDraw.setCanvasSize(500, 500);
        StdDraw.setScale(0, 1);
        int N = 50;
        int i = 1;
        while (i <= N) {
            double randomObjectGen = randomGenerator.nextDouble();
            if (randomObjectGen > 0.00 && randomObjectGen < 0.80) {
                //MAKE CIRCLE
                double x = randomGenerator.nextDouble();
                double y = randomGenerator.nextDouble();
                double r = 0.1 * randomGenerator.nextDouble();
                Lab7_Circle circle = new Lab7_Circle(x, y, r, StdDraw.PRINCETON_ORANGE);
                if (circle.computeArea() > 0.005) {
                    circles.add(circle);
                    i++;
                }
            } else {
                //MAKE RECT
                double x = randomGenerator.nextDouble();
                double y = randomGenerator.nextDouble();
                double width = 0.2 * randomGenerator.nextDouble();
                double height = 0.2 * randomGenerator.nextDouble();
                Lab7_Rectangle rectangle = new Lab7_Rectangle(x, y, width, height, StdDraw.BOOK_LIGHT_BLUE);
                if (rectangle.computeArea() > 0.005) {
                    rectangles.add(rectangle);
                    i++;
                }
            }
        }
        for (Lab7_Circle c : circles) {
            c.draw();
        }
        for (Lab7_Rectangle r : rectangles) {
            r.draw();
        }
        System.out.println(circles.size() + " circles and " + rectangles.size() + " rectangles created.");
    }
}
