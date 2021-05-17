import java.awt.Color;
import java.util.Random;

/**
 * Draw M random non-overlapping circles
 *
 */
public class NonOverlappingCircles {

	private static class MyCircle {
		private double x;
		private double y;
		private double radius;
		private Color color;

		public MyCircle(double x, double y, double radius, Color color) {
			this.x = x;
			this.y = y;
			this.radius = radius;
			this.color = color;
		}

		public double distance(MyCircle p) {
			return Math.pow((x-p.getX())*(x-p.getX())+(y-p.getY())*(y-p.getY()), 0.5);
		}

		public double getX() { return x; }
		public double getY() { return y; }
		public double getRadius() { return radius; }

		public void draw() {
			StdDraw.setPenColor(color);
			StdDraw.filledCircle(x, y, radius);
		}
	}

	public static void main(String[] args) {

		int plateCount = 1_000;
		double radiusMax = 0.2;
		double radiusMin = 0.006;

		double xScaleMax = 2.0;
		double yScaleMax = 2.0;

		// canvas parameters
		int canvas_width = 600;
		int canvas_height = 600;
		StdDraw.clear(StdDraw.WHITE);
		StdDraw.setCanvasSize(canvas_width, canvas_height);
		StdDraw.setXscale(0, xScaleMax);
		StdDraw.setYscale(0, yScaleMax);
		
		MyCircle[] plateArray = new MyCircle[plateCount];
		Random random = new Random();
		int counter = 0;
		while ( counter < plateCount) {
			double x = random.nextDouble() * xScaleMax;
			double y = random.nextDouble() * yScaleMax;
			double r = radiusMin + (radiusMax-radiusMin) * random.nextDouble();
			Color c = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
			if ((x-r > 0) && (x+r < xScaleMax) && (y-r > 0) && (y+r < yScaleMax)) {
				MyCircle p = new MyCircle(x,y,r,c);
				boolean intersect = false;
				for (MyCircle myCircle : plateArray)
					if (myCircle != null)
						if (myCircle.distance(p) < p.getRadius() + myCircle.getRadius()) {
							intersect = true;
							break;
						}
				if (!intersect) {
					plateArray[counter++] = p;
					p.draw();
				}
			}
		}
		StdDraw.show();
		System.out.println("Program finished.");
		StdDraw.save("output.png"); // save drawing to a file
	}
}