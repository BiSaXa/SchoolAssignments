import java.util.Scanner;

public class PointsInsideATriangle {

	public static void main(String[] args) {
		/**
		 *  Ask for the points that will be generated to the user.
		 */
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter how many points you would like to see.");
		int pointNumber = input.nextInt();
		
		/**
		 * Canvas settings.
		 */
		StdDraw.setCanvasSize(700, 700);
		StdDraw.setXscale(0, 1);
		StdDraw.setYscale(0, 1);
		
		/**
		 * Due to the argument types od StdDraw.polygon function, we keep our coordinates in separate arrays.
		 */
		double xCoordinates [] = new double [3];
		double yCoordinates [] = new double [3];
		/**
		 * Fill the arrays with random doubles between [0,1).
		 */
		for (int i = 0; i < 3; i++) {
			xCoordinates[i] = Math.random();
			yCoordinates[i] = Math.random();
		}
		/**
		 * Draw the triangle with StdDraw.polygon function.
		 */
		StdDraw.polygon(xCoordinates, yCoordinates);
		StdDraw.setPenRadius(0.01);
		int counter = 0;
		/**
		 * While counter is less than the amount of points needed, calculate cosine for each pair of corners of the triangle
		 * according to the formula. Get the degrees from cosine values. If the sum of the degrees are equal to 360, that means the point
		 * is inside the triangle. Since we are making the calculation with doubles, 0.001 was chosen as the accepted margin of error arbitrarily.
		 * If the absolute value of sum - 360 is less than 0.001, the colour should be red. Blue if otherwise. We draw the point after changing the colour.
		 * We upgrade the counter by one.
		 */
		while (counter < pointNumber) {
			double pointX = Math.random();
			double pointY = Math.random();
			double cos1 = ((pointX-xCoordinates[0]) * (pointX-xCoordinates[1])+(pointY-yCoordinates[0])*(pointY-yCoordinates[1])) 
					/ (Math.pow((xCoordinates[0]-pointX)*(xCoordinates[0]-pointX) + (yCoordinates[0]-pointY)*(yCoordinates[0]-pointY), 0.5) 
							* (Math.pow((xCoordinates[1]-pointX)*(xCoordinates[1]-pointX)+(yCoordinates[1]-pointY)*(yCoordinates[1]-pointY), 0.5)));
			double cos2 = ((pointX-xCoordinates[1]) * (pointX-xCoordinates[2])+(pointY-yCoordinates[1])*(pointY-yCoordinates[2])) 
					/ (Math.pow((xCoordinates[1]-pointX)*(xCoordinates[1]-pointX) + (yCoordinates[1]-pointY)*(yCoordinates[1]-pointY), 0.5) 
							* (Math.pow((xCoordinates[2]-pointX)*(xCoordinates[2]-pointX)+(yCoordinates[2]-pointY)*(yCoordinates[2]-pointY), 0.5)));
			double cos3 = ((pointX-xCoordinates[2]) * (pointX-xCoordinates[0])+(pointY-yCoordinates[2])*(pointY-yCoordinates[0])) 
					/ (Math.pow((xCoordinates[2]-pointX)*(xCoordinates[2]-pointX) + (yCoordinates[2]-pointY)*(yCoordinates[2]-pointY), 0.5) 
							* (Math.pow((xCoordinates[0]-pointX)*(xCoordinates[0]-pointX)+(yCoordinates[0]-pointY)*(yCoordinates[0]-pointY), 0.5)));
			double degree1 = Math.toDegrees(Math.acos(cos1));
			double degree2 = Math.toDegrees(Math.acos(cos2));
			double degree3 = Math.toDegrees(Math.acos(cos3));
			
			if (Math.abs((degree1 + degree2 + degree3) - 360 ) < 0.001 )
				StdDraw.setPenColor(StdDraw.BOOK_RED);
			else
				StdDraw.setPenColor(StdDraw.BOOK_BLUE);
			StdDraw.point(pointX, pointY);
			counter++;
		}
		input.close();	
	}
}