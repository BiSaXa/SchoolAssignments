import java.util.Scanner;

public class PointsInsideACircle {
	public static void main(String[] args) {
		/**
		 * Ask the user for circle radius.
		 */
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter an integer between 1 and 10 for radius. [1, 10] :");
		int radius = input.nextInt();
		/**
		 * Control if the radius is between bounds. Ask the question until an integer between the bounds is entered
		 */
		while (radius < 1 || radius > 10) {
			System.out.println("Integer not in the bounds. Try again.");
			radius = input.nextInt();
		}
		/**
		 *  Ask for the points that will be generated.
		 */
		System.out.println("Please enter how many points you would like to see.");
		int pointNumber = input.nextInt();
		/**
		 * Set canvas size. In order to centralize our circle and support the circle with the biggest radius, interval
		 * for x and y scale is decided as -10,10
		 */
		StdDraw.setCanvasSize(700, 700);
		StdDraw.setXscale(-10, 10);
		StdDraw.setYscale(-10, 10);
		/**
		 * Create a circle centered at 0,0 with given radius.
		 */
		StdDraw.circle(0, 0, radius);
		/**
		 * Set pen radius to be 0.01
		 */
		StdDraw.setPenRadius(0.01);
		/**
		 * While our counter is smaller than the point number that was given, generate points and change their colours according
		 * to the distance that is calculated for that point. Center of the circle is 0,0, therefore we do not need to subtract
		 * x2 and y2 in the distance formula since they are 0. If the distance is smaller than the radius, which means that the point
		 * is inside the circle, change pen colour to red. It should be blue otherwise. Draw the point after deciding on the colour.
		 * Upgrade the counter by one.
		 */
		int counter = 0;
		while (counter < pointNumber) {
			double x = Math.random()*20 - 10;
			double y = Math.random()*20 - 10;
			double distance = Math.sqrt((x)*(x) + (y)*(y));
			if (distance < radius)
				StdDraw.setPenColor(StdDraw.BOOK_RED);
			else
				StdDraw.setPenColor(StdDraw.BOOK_BLUE);
			StdDraw.point(x, y);
			counter++;
		}
		input.close();

	}

}