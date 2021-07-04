import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CardMatch {
	public static void main(String[] args) throws Exception {
		/**
		 * Adjust canvas settings.
		 */
		int canvasWidth = 500;
		int canvasHeight = 700;
		StdDraw.setCanvasSize(canvasWidth, canvasHeight);
		StdDraw.setXscale(0, canvasWidth);
		StdDraw.setYscale(0, canvasHeight);
		/**
		 * Read the file.
		 */
		File file = new File("rectangles.txt");
		Scanner input = new Scanner(file);
		/**
		 * Array list to keep the cards.
		 */
		ArrayList<Cards> cards = new ArrayList<>();
		/**
		 * While the file has a next line, get the fields of a Card object from it.
		 * File format:
		 * Down left corner's x coordinate, that corner's y coordinate, width, height
		 * Add each card to the array.
		 */
		while (input.hasNext()) {
			String [] fields = input.nextLine().split(",");
			double width = Double.parseDouble(fields[2]);
			double height = Double.parseDouble(fields[3]);
			double x = Double.parseDouble(fields[0]) + width/2;
			double y = Double.parseDouble(fields[1]) + height/2;
			Cards c = new Cards(x, y, width, height);
			cards.add(c);
		}
		input.close();
		/**
		 * Integer array for cards types. For 12 cards, 6 different cards with pairs.
		 * 0 -> Book blue circle
		 * 1 -> Green rectangle
		 * 2 -> Book red square
		 * 3 -> Magenta circle
		 * 4 -> Princeton orange rectangle
		 * 5 -> Light gray square
		 */
		int [] typeArray = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
		/**
		 * Shuffle the type array and assign a type to each card starting from the 0th index for the array and the array list.
		 */
		shuffle(typeArray, typeArray.length);
		int i = 0;
		for (Cards c: cards) {
			StdDraw.filledRectangle(c.getX(), c.getY(), c.getWidth()/2, c.getHeight()/2);
			c.setType(typeArray[i++]);
		}

		int mousePauseDuration = 250;
		int previousCard = 0;
		int openCardCount = 0;
		int totalFoundPairs = 0;
		int trial = 0;
		while (true) {
			if (StdDraw.isMousePressed()) {
				/**
				 * If the mouse is pressed, get the x and y coordinates of the mouse.
				 */
				StdDraw.pause(mousePauseDuration);
				double x = StdDraw.mouseX();
				double y = StdDraw.mouseY();
				for (Cards c: cards) {
					/**
					 * If card c is clicked, clear the area and check if this is the first card. If this is
					 * the first card, keep its index.
					 */
					if(c.isClicked(x, y)) {
						openCardCount++;
						StdDraw.clear();
						if (openCardCount == 1)
							previousCard = cards.indexOf(c);
						/**
						 * Go through the cards, if the card a is the same as card c (the second card) or card a is the same as
						 * the previous card or the previous card and the current card are found, continue
						 */
						for (Cards a: cards) {
							StdDraw.setPenColor(StdDraw.BLACK);
							if (cards.indexOf(a) == cards.indexOf(c) || cards.indexOf(a) == previousCard || cards.get(previousCard).isFound()
									|| a.isFound())
								continue;
							/**
							 * Draw a filled rectangle, representing backside of a card.
							 */
							StdDraw.filledRectangle(a.getX(), a.getY(), a.getWidth()/2, a.getHeight()/2);
						}
						/**
						 * Open the previous and the current card.
						 */
						cards.get(previousCard).flipCard();
						c.flipCard();
					}
					/**
					 * If the types of these cards are the same, mark them as found. Increase the number of total found pairs and
					 * trial as one. Else, just raise the trial.
					 */
					if (openCardCount == 2) {
						if (cards.get(previousCard).getType() == c.getType()) {
							cards.get(previousCard).setFound(true); c.setFound(true);
							totalFoundPairs++; trial++;
						}
						else
							trial++;
						/**
						 * Reset the open card counter.
						 */
						openCardCount = 0;
					}
					/**
					 * If we have found all of the pairs, display result and break.
					 */
					if (totalFoundPairs == 6) {
						StdDraw.setPenColor(StdDraw.BLACK);
						StdDraw.clear();
						StdDraw.text(250, 300, "Game completed in " +trial +" trials.");
						break;
					}
				}	
			}
		}
	}
	/**
	 * This method is used to shuffle the contents of an array.
	 * @param inputArray: Input array
	 * @param n: Length of the array.
	 */
	public static void shuffle( int inputArray[], int n) {
		Random r = new Random();
		/**
		 * Go through the entire array backwards and pick a number between 0 and i. Switch the jth and ith element. 
		 */
		for (int i = n - 1; i > 0; i--) {
			int j = r.nextInt(i);
			int temp = inputArray[i];
			inputArray[i] = inputArray[j];
			inputArray[j] = temp;
		}
	}
}