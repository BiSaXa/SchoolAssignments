import java.util.Random; // used to generate random values for circle properties
import java.util.Scanner; // for getting input from user

// A program that generates a predefined number (N) of non-overlapping random 
// circles and draws them using StdDraw.
public class Lab3 {
	
    public static void main(String[] args) {
    	
    	// number of non-overlapping random circles to be created
    	Scanner in = new Scanner(System.in);
    	System.out.print("Enter N: ");
    	int N = in.nextInt();
    	in.close();

    	// StdDraw setup
    	// -----------------------------------------------------------------------
    	// set the size of the drawing canvas
    	int canvasWidth = 600, canvasHeight = 600;
    	StdDraw.setCanvasSize(canvasWidth, canvasHeight);
    	// set the scale of the coordinate system
    	StdDraw.setScale(0, 1); // both x and y coordinates are in the range [0, 1]

    	// create a 2D array for storing data of non-overlapping random circles
    	// N circles -> N rows
    	// 3 values (x, y and r) are stored for each circle -> 3 columns
    	double[][] circles = new double[N][3];

    	// generate N non-overlapping random circles
    	// -----------------------------------------------------------------------
    	Random randomGenerator = new Random(); // create a random number generator
    	double rMin = 0.01, rMax = 0.2; // range for random circle radiuses

    	// loop until N non-overlapping random circles are created
    	int circleCount = 0;
    	while (circleCount < N) {
    		// create a random radius value in the range [rMin, rMax)
    		double r = rMin + (rMax - rMin) * randomGenerator.nextDouble();
    		// create random x and y ensuring the whole circle is in the canvas
    		double x = r + (1 - 2 * r) * randomGenerator.nextDouble();
    		double y = r + (1 - 2 * r) * randomGenerator.nextDouble();
    		// create the random circle as an array that stores random x, y and r
    		double[] newCircle = { x, y, r };
    		// create a flag that shows if there is an overlap between the newly
    		// created circle (newCircle) and any of the previously created circles
    		// stored in the 2D array (circles)
    		boolean overlap = false;
    		// check each non-overlapping circle (storedCircle) in the circles array
    		for (double[] storedCircle : circles) {
    			// using a for-each loop
    			// get the radius values of both newCircle and storedCircle
    			double r1 = newCircle[2], r2 = storedCircle[2];
    			// two circles intersect if the distance between their centers is
    			// smaller than the sum of their radiuses
    			if (computeDistance(newCircle, storedCircle) < (r1 + r2)) {
    				overlap = true;
    				break; // end the loop as an overlap is detected
    			}
    		}
    		// recreate the random circle (newCircle) if an overlap is detected
    		if (overlap)
    			continue; // continue from the next iteration of the while loop

    		// add the non-overlapping circle newCircle to the circles array
    		circles[circleCount] = newCircle;
    		circleCount++; // increase the number of non-overlapping circles by 1

    		// print the number of non-overlapping random circles created so far
    		System.out.printf("Circle count: %4d\n", circleCount);
    		// draw the circle on the drawing canvas
    		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
    		StdDraw.filledCircle(x, y, r);
    	}
    	// save the resulting image as a file
    	String outputFileName = "out_" + N + ".png";
    	StdDraw.save(outputFileName);
    	System.out.println("Program finished.");
    }

    // A method for computing and returning the distance between the centers of
    // the 2 circles given as the input arguments
    public static double computeDistance(double[] circle1, double[] circle2) {
    	double x1 = circle1[0], x2 = circle2[0]; // x coordinates for the circles
    	double y1 = circle1[1], y2 = circle2[1]; // y coordinates for the circles
    	// compute and return the distance
    	return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}