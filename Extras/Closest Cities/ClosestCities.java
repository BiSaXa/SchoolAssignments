import java.util.Random;

/**
 * Create cities with random coordinates and plot nearest two cities
 *
 */
public class ClosestCities {
	public static void main(String[] args) {

		String[] cityNames = {"A","B","C","D","E","F","G","H"};

		// Create random coordinates for cities
		double[][] coordinates = new double[cityNames.length][2];
		Random random = new Random();
		for (int i = 0; i < coordinates.length; i++) {
			coordinates[i][0] = random.nextDouble();
			coordinates[i][1] = random.nextDouble();
		}

		// find nearest two cities
		double minDistance = Double.MAX_VALUE;
		int cityInd1 = 0;
		int cityInd2 = 0;
		for (int i = 0; i < coordinates.length-1; i++) {
			for (int j = i + 1; j < coordinates.length; j++) {
				// get (x,y) coordinates of city1 and city2
				double x1 = coordinates[i][0];
				double y1 = coordinates[i][1];
				double x2 = coordinates[j][0];
				double y2 = coordinates[j][1];

				// compute Euclidean distance between city1 and city2
				double distance = Math.pow(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2), 0.5);

				if (distance < minDistance) {
					minDistance = distance;
					cityInd1 = i;
					cityInd2 = j;
				}
			}
		}
		System.out.printf("Closest cities are: %s and %s. Distance = %5.2f\n",
				cityNames[cityInd1], cityNames[cityInd2], minDistance);

		// plot cities
		int canvas_width = 600;
		int canvas_height = 600;
		StdDraw.setCanvasSize(canvas_width, canvas_height);
		StdDraw.setXscale(0, 1);
		StdDraw.setYscale(0, 1);
		StdDraw.enableDoubleBuffering();

		for (int i = 0; i < cityNames.length; i++) {
			StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
			StdDraw.filledCircle(coordinates[i][0], coordinates[i][1], 0.02);
			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.text(coordinates[i][0]+0.04, coordinates[i][1], cityNames[i]);
		}
		// plot nearest cities
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledCircle(coordinates[cityInd1][0], coordinates[cityInd1][1], 0.01);
		StdDraw.filledCircle(coordinates[cityInd2][0], coordinates[cityInd2][1], 0.01);
		StdDraw.line(coordinates[cityInd1][0], coordinates[cityInd1][1],
				coordinates[cityInd2][0], coordinates[cityInd2][1]);
		StdDraw.show();
		System.out.println("Program finished");
	}
}