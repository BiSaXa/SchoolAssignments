import java.util.Scanner;

public class GeometryCalculator {
	public static void main(String [] args) {
		/**
		 * Ask user for selection and generate the menu.
		 */
		Scanner input = new Scanner(System.in);
		System.out.println("Geometry Calculator");
		System.out.println("1. Area of a circle.\n2. Area of a triangle.\n3. Area of a quadrilateral.\n4. Quit.");
		System.out.println("Enter your selection 1-3:");
		int menuSelection = input.nextInt();
		/**
		 * Flag to determine whether we continue the program or not.
		 */
		boolean flag = false;
		/**
		 * Canvas and pen colour settings.
		 */
		StdDraw.setCanvasSize(700, 700);
		StdDraw.setXscale(0, 10);
		StdDraw.setYscale(0, 10);
		StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
		/**
		 * Case 1: Circle, Case 2: Triangle, Case 3: Quadrilateral. While the flag is false, i.e., while we need to continue the program,
		 * perform the calculations for selections determined by the cases.
		 */
		while (!flag) {
			switch(menuSelection) {
			case 1:
				/**
				 * Clear the previous shape and area result.
				 */
				StdDraw.clear();
				/**
				 * Get the area and the radius. If the radius is bigger than the x or y coordinates of the center or 
				 * if diameter is bigger than the scaling. 
				 */
				System.out.println("Please enter a center for the circle. x and y coordinates' scale: [0,10]");
				double x = input.nextDouble();
				double y = input.nextDouble();
				System.out.println("Please enter a radius for the circle between [1-10].");
				double radius = input.nextDouble();
				if (x < radius || y < radius || radius*2 > 10) {
					System.out.println("Your circle will not fit the canvas. Wish to continue? (y/n):");
					/**
					 * Ask the user if they want to continue even though the circle will not fit the canvas. If they do not wish
					 * to continue, break the loop.
					 */
					String a = input.next();
					char answer = a.toLowerCase().charAt(0);
					if (answer == 'n')
						break;
				}
				/**
				 * Plot the shape and calculate the area according to the formula, write the result to the right bottom of the canvas.
				 */
				double area = Math.PI*radius*radius;
				StdDraw.filledCircle(x, y, radius);
				StdDraw.text(9, 0.5, "Area:"+Math.round(area));
				break;
			case 2:
				/**
				 * Clear the previous shape and area result.
				 */
				StdDraw.clear();
				/**
				 * Ask the user for the coordinates of the triangle. Keep the x and y coordinates in arrays due to the nature of StdDraw.filledPolygon().
				 */
				System.out.println("Please enter three points for the triangle. x and y coordinates' scale: [0,10]:");
				double [] xCoordinates = new double [3];
				double [] yCoordinates = new double [3];
				for (int i = 0; i < 3; i++) {
					System.out.println("Please enter x and y coordinate for point " +(i+1));
					xCoordinates[i] = input.nextDouble();
					yCoordinates[i] = input.nextDouble();
				}
				/**
				 * Plot the shape and calculate the area according to the formula, write the result to the right bottom of the canvas.
				 */
				StdDraw.filledPolygon(xCoordinates, yCoordinates);
				area = Math.abs((xCoordinates[2] - xCoordinates[0])*(yCoordinates[1] - yCoordinates[0]) 
						- (xCoordinates[1] - xCoordinates[0])*(yCoordinates[2] - yCoordinates[0])) / 2;
				System.out.println("Area:" +Math.round(area));
				break;
			case 3:
				/**
				 * Clear the previous shape and area result.
				 */
				StdDraw.clear();
				/**
				 * Ask the user for the coordinates of the quadrilateral. Keep the x and y coordinates in arrays due to the nature of StdDraw.filledPolygon().
				 */
				System.out.println("Please enter four points for the quadrilateral, starting from down-left corner and"
						+ " going reverse clockwise direction. x and y coordinates' scale: [0,10]:");
				xCoordinates = new double [4];
				yCoordinates = new double [4];
				for (int i = 0; i < 4; i++) {
					System.out.println("Please enter x and y coordinate for point " +(i+1));
					xCoordinates[i] = input.nextDouble();
					yCoordinates[i] = input.nextDouble();
				}
				/**
				 * Plot the shape and calculate the area according to the formula, write the result to the right bottom of the canvas.
				 */
				area = Math.abs((xCoordinates[2] - xCoordinates[0])*(yCoordinates[1] - yCoordinates[0]) 
						- (xCoordinates[1] - xCoordinates[0])*(yCoordinates[2] - yCoordinates[0])) / 2 + 
						Math.abs((xCoordinates[3] - xCoordinates[0])*(yCoordinates[2] - yCoordinates[0]) 
								- (xCoordinates[2] - xCoordinates[0])*(yCoordinates[3] - yCoordinates[0])) / 2;
				StdDraw.filledPolygon(xCoordinates, yCoordinates);
				StdDraw.text(9, 0.5, "Area:"+Math.round(area));
				break;
			}
			/**
			 * After plotting, ask the user to make another selection or to quit.
			 */
			System.out.println("Enter your selection to continue. 4 to quit.");
			menuSelection = input.nextInt();
			/**
			 * Check if the selection is 4, if so, change the flag to be true.
			 */
			if (menuSelection == 4)
				flag = true;
		}
		/**
		 * Print a message for quitting.
		 */
		System.out.println("Quitting...");
		input.close();
	}
}