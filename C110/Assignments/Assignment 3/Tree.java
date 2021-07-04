/**
 * Tree class with an x pos instance variable and three finalized values about tree height, width and radius
 * Has a drawTree method which draws the tree with respective values
 */

public class Tree {

    // Private instance variables given in the UML diagram
    private double centerX;
    private final double TREE_BODY_HEIGHT = 0.08;
    private final double TREE_BODY_WIDTH = 0.02;
    private final double TREE_RADIUS = 0.04;

    public Tree() {
    } // Default constructor

    /**
     * Tree constructor with one parameter
     *
     * @param centerX x position double
     */
    public Tree(double centerX) {
        this.centerX = centerX;
    }

    /**
     * Void method that draws the trees with its final variables and given x position
     */
    public void drawTree() {
        StdDraw.setPenColor(StdDraw.PINK);
        StdDraw.filledRectangle(centerX, 0, TREE_BODY_WIDTH / 2, TREE_BODY_HEIGHT);
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledCircle(centerX, TREE_BODY_HEIGHT + TREE_BODY_HEIGHT / 2, TREE_RADIUS);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.rectangle(centerX, 0, TREE_BODY_WIDTH / 2, TREE_BODY_HEIGHT);
        StdDraw.circle(centerX, TREE_BODY_HEIGHT + TREE_BODY_HEIGHT / 2, TREE_RADIUS);
        StdDraw.show();
    }
}