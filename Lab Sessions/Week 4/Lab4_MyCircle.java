public class Lab4_MyCircle {

    private double x;
    private double y;
    private double r;

    public Lab4_MyCircle(double x, double y, double r) { // Constructor with 3 params
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public double getRad(){ // Getter method for radius
        return r;
    }

    public void draw(){ // Draw method for drawing circle with StdDraw
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledCircle(x, y, r);
    }

    public double computeDistance(Lab4_MyCircle circle){ // Distance calculator method using an only parameter circle object
        double x1 = this.x, x2 = circle.x; // x coordinates for the circles
        double y1 = this.y, y2 = circle.y; // y coordinates for the circles
        // compute and return the distance
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
