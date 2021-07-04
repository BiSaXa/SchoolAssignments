import java.util.Random;

public class Lab5_Ball {

    public double x;
    public double y;
    public double vx;
    public double vy;
    public double r;

    public Lab5_Ball(double x, double y, double vx, double vy, double r) { // Constructor with 5 params

        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.r = r;

    }

    public void draw(){ // Draw method for drawing circle with StdDraw
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(x, y, r);
    }
}
