import java.awt.Color;
import java.util.Random;

/**
 * Estimation of PI using random points
 *
 * Generate M random points where N of them falls within
 * a circle. Using the ratio of canvas area to the
 * circle area, you can estimate the PI.
 *
 */
public class PiEstimation {
	public static void main(String[] args) {

		// canvas parameters
		int canvas_width = 600;
		int canvas_height = 600;
		double xScaleMax = 2.0;
		double yScaleMax = 2.0;

		// circle parameters
		double circle_center_x = xScaleMax/2.0;
		double circle_center_y = yScaleMax/2.0;
		double circle_radius   = 0.8;
		double circle_border_thickness = 0.002;
		int pointCount = 10_000;

		Random randomGenerator = new Random();

		// prepare canvas
		StdDraw.clear(StdDraw.WHITE);
		StdDraw.setCanvasSize(canvas_width, canvas_height);
		StdDraw.setXscale(0, xScaleMax);
		StdDraw.setYscale(0, yScaleMax);
		StdDraw.enableDoubleBuffering();

		// draw circle
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(circle_border_thickness); 
		StdDraw.circle(circle_center_x, circle_center_y, circle_radius);

		// count points inside
		int counter = 0;
		int pointsInside = 0;
		while ( counter < pointCount) {
			double x = randomGenerator.nextDouble() * xScaleMax;
			double y = randomGenerator.nextDouble() * yScaleMax;
			double dist = Math.pow((x-circle_center_x)*(x-circle_center_x)+(y-circle_center_y)*(y-circle_center_y), 0.5);
			if (dist <= circle_radius) {
				StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
				pointsInside++;
			}
			else
				StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
			StdDraw.setPenRadius(0.001); 
			StdDraw.filledCircle(x, y, 0.003);
			counter++;
		}
		StdDraw.show();
		double estimatedPI = (xScaleMax * yScaleMax * pointsInside) / (pointCount * circle_radius * circle_radius);
		double error = Math.abs(Math.PI-estimatedPI);
		System.out.printf("Estimated PI: %.4f (#Points: %d, Error: %.5f)\n", estimatedPI, pointCount, error);
		// save drawing to a file
		StdDraw.save("output.png"); // in .png or .jpg format
	}
}