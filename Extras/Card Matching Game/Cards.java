public class Cards {
	private double x;
	private double y;
	private double width;
	private double height;
	private boolean isFound;
	private int type;

	/**
	 * Constructor for Cards.
	 * @param x: x coordinate of the center 
	 * @param y: y coordinate of the center
	 * @param width: width of the rectangle
	 * @param height: height of the rectangle
	 */
	public Cards(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	/**
	 * Getter methods for each field. Setter methods for the type and found fields.
	 */
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public boolean isFound() {
		return isFound;
	}

	public void setFound(boolean isFound) {
		this.isFound = isFound;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	/**
	 * Controls if that card is clicked by the mouse.
	 * @param mouseX: x coordinate of the mouse.
	 * @param mouseY: y coordinate of the mouse.
	 * @return: If the card is clicked or not.
	 */
	public boolean isClicked(double mouseX, double mouseY) {
		/**
		 * Compute the minimum and maximum x y values for the card.
		 */
		double minX = x - width / 2;
		double minY = y - height / 2;
		double maxX = x + width / 2;
		double maxY = y + height / 2;
		/**
		 * If the mouse's coordinates are inside of that card, return true.
		 */
		if (mouseX > minX && mouseX < maxX && mouseY > minY && mouseY < maxY)
			return true;
		
		return false;
	}
	/**
	 * Flips the card open by drawing a frame and a shape according to the card's type..
	 */
	public void flipCard() {
		/**
		 * Draw a frame for the card.
		 */
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.rectangle(x, y, width / 2, height / 2);
		/**
		 * Draw a shape depending on the type of the card.
		 */
		switch(type) {
		case 0:
			StdDraw.setPenColor(StdDraw.BOOK_BLUE);
			StdDraw.filledCircle(x, y, 15);
			break;
		case 1:
			StdDraw.setPenColor(StdDraw.GREEN);
			StdDraw.filledRectangle(x, y, 10, 20);
			break;
		case 2:
			StdDraw.setPenColor(StdDraw.BOOK_RED);
			StdDraw.filledSquare(x, y, 10);
			break;
		case 3:
			StdDraw.setPenColor(StdDraw.MAGENTA);
			StdDraw.filledCircle(x, y, 15);
			break;
		case 4:
			StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
			StdDraw.filledRectangle(x, y, 10, 20);
			break;
		case 5:
			StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
			StdDraw.filledSquare(x, y, 10);
			break;
		}
	}
}