/**
 * Building class that has five instance variable including a finalized height value for building floor
 * Has a drawBuilding method which draws rectangles with respective values in a loop continuing for floor count
 */

import java.awt.*;

public class Building {

    // Private instance variables given in the UML diagram
    private int floorCount;
    private double centerX;
    private double buildingWidth;
    private Color buildingColor;
    private final double FLOOR_HEIGHT = 0.06;

    public Building() {
    } // Default constructor

    /**
     * Building constructor with four parameters
     *
     * @param floorCount    floor count integer
     * @param centerX       x position double
     * @param buildingWidth width of the building double
     * @param buildingColor color of the building Color
     */
    public Building(int floorCount, double centerX, double buildingWidth, Color buildingColor) {
        this.floorCount = floorCount;
        this.centerX = centerX;
        this.buildingWidth = buildingWidth;
        this.buildingColor = buildingColor;
    }

    /**
     * Void method that draws the buildings floor by floor with their given data
     */
    public void drawBuilding() {
        double y = FLOOR_HEIGHT / 2;
        for (int floor = 1; floor <= floorCount; floor++) {
            StdDraw.setPenColor(buildingColor);
            StdDraw.filledRectangle(centerX, y, buildingWidth / 2, FLOOR_HEIGHT / 2);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.rectangle(centerX, y, buildingWidth / 2, FLOOR_HEIGHT / 2);
            y = y + FLOOR_HEIGHT;
        }
        double[] polyX = {centerX - buildingWidth / 2, centerX + buildingWidth / 2, centerX};
        double[] polyY = {y - FLOOR_HEIGHT / 2, y - FLOOR_HEIGHT / 2, y};
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledPolygon(polyX, polyY);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.polygon(polyX, polyY);
        StdDraw.show();
    }
}