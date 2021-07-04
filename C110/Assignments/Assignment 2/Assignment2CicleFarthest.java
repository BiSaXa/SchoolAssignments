/**
 * Program that find the maximum distance between two points input from user
 * and draw the largest circle with using the distance between two points as diameter using StdDraw library.
 * @author Arda Serdar Pektezol
 * @since Date: 15.03.2021
 */

public class Assignment2CicleFarthest {
	/**
	 * Opens up an StdDraw canvas with 600x600 size, constantly checks for mouse presses until the click count reaches 10,
	 * if mouse is clicked and a circle is drawn, places its x and y coordinates to two one-dimensional arrays and stores them,
	 * goes through every point and compares their distance, in order to find maximum distance between two points, store these points' coordinates,
	 * finally, shows the two points in blue and draws a circle in the middle of these points with a radius of half of their distance.
	 * @param args Main input arguments are not used
	 */
    public static void main(String[] args) {
	   int canvasWidth = 600; //Initializing canvas width and height
	   int canvasHeight = 600;
	   double[] xValues = new double[10]; //Declaring two arrays for x and y values with length 10.
	   double[] yValues = new double[10];
	   StdDraw.setCanvasSize(canvasWidth, canvasHeight); //Creating the canvas
	   StdDraw.setXscale(0, 1); //Setting the scale of the canvas
	   StdDraw.setYscale(0, 1);
	   StdDraw.clear(StdDraw.WHITE); //Clearing up the canvas for the first time
	   int mouseClick = 0; //Storing mouse clicks because we don't want more than 10
	   while(mouseClick < 10) {
		   if(StdDraw.isMousePressed()) { //If mouse is pressed at any time and there are less than 10 mouse clicks;
			   double x = StdDraw.mouseX(); //Get x and y position of the mouse
			   double y = StdDraw.mouseY();
			   StdDraw.setPenColor(StdDraw.BLACK);
			   StdDraw.filledCircle(x, y, 0.01); //Draw a mini circle where it is clicked
			   StdDraw.pause(400); //Wait 400ms for another click
			   xValues[mouseClick] = x; //Store x and y values to their arrays
			   yValues[mouseClick] = y;
			   mouseClick++;
		   }
	   }
	   //Resume after 10 clicks
	   double maxDistance = 0; //Initialize double for maximum distance value
	   int firstMaxIndex = 0; //Index of first max point
	   int secondMaxIndex = 0; //Index of second max point
	   double circleCenterX = 0; //X position of final circle
	   double circleCenterY = 0; //Y position of final circle
	   for(int j = 0; j < xValues.length; j++) { //Loop for checking every individual index in both xValues and yValues
		   for(int k = 0; k < yValues.length; k++) {
			   if(distance(xValues, yValues, j, k) > maxDistance) { //If a new distance is bigger than older max distance, this is now new max distance
				   maxDistance = distance(xValues, yValues, j, k); //Declare maxDistance with new maximum distance value using distance method
				   firstMaxIndex = j; //Giving two max indexes their final value
				   secondMaxIndex = k;
			   }
		   }
	   }
	   circleCenterX = (xValues[firstMaxIndex]+xValues[secondMaxIndex])/2.0; //Getting the center of final circle by finding the average in two points
	   circleCenterY = (yValues[firstMaxIndex]+yValues[secondMaxIndex])/2.0;
	   StdDraw.setPenColor(StdDraw.BLACK);
	   StdDraw.circle(circleCenterX, circleCenterY, maxDistance/2.0); //Drawing the final circle
	   StdDraw.setPenColor(StdDraw.BLUE);
	   StdDraw.filledCircle(xValues[firstMaxIndex], yValues[firstMaxIndex], 0.02); //Highlighting the two points with blue
	   StdDraw.filledCircle(xValues[secondMaxIndex], yValues[secondMaxIndex], 0.02);
	   StdDraw.show();
    }
    
    /**
     * Method that calculates distance between two points using Pythagoras theorem
     * @param xValues Getting all x values from every point in an array
     * @param yValues Getting all y values from every point in an array
     * @param index1 First index of array, useful to pinpoint one of the max point location
     * @param index2 Second index of array, useful to pinpoint one of the max point location
     * @return distance value
     */
    public static double distance(double[] xValues, double[] yValues, int index1, int index2) {
	    double distance = Math.sqrt(Math.pow((xValues[index1]-xValues[index2]), 2)+Math.pow((yValues[index1]-yValues[index2]), 2));
	    return distance;
    }
}