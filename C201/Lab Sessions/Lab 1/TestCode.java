import java.util.Random; // used for randomly creating circles and rectangles
import java.util.ArrayList; // used for storing shapes (circles and rectangles)
import java.util.Collections; // used for sorting the array list of shapes
import java.awt.Color; // to use Color type (class) for Shape.color data field

// A program that generates N random shapes as circles with 0.65 probability or
// rectangles otherwise. These circles and rectangles are drawn in different
// colors and their areas are displayed at their centers with 3 decimal precision. 
// The program also sorts the shapes in increasing order based on their areas,
// prints type and area of each sorted shape on the console, and highlights the
// largest shape by drawing it in color green.  
public class TestCode {
   public static void main(String[] args) {
      int N = 20; // total number of shapes to be drawn
      double circleProbability = 0.65; // probability value for creating a circle
      // a random number generator for randomly creating circles and rectangles
      Random rGen = new Random();
      // minimum area value suitable for 3 decimal precision
      // (smaller area values are displayed as 0.000)
      double minArea = 0.0005;
      // an array list for storing circles and rectangles as Shape objects
      ArrayList<Shape> shapes = new ArrayList<Shape>();

      // Drawing setup
      // ------------------------------------------------------------------------
      // set the size of the drawing canvas
      int canvasWidth = 750, canvasHeight = 750;
      StdDraw.setCanvasSize(canvasWidth, canvasHeight);
      // set the scale of the coordinate system as the range [0, 1]
      StdDraw.setXscale(0, 1);
      StdDraw.setYscale(0, 1);
      // double buffering is used to enable computer animations (for animating
      // the drawing of circles and rectangles one by one)
      StdDraw.enableDoubleBuffering();
      // clear the offscreen drawing canvas as color white (double buffering)
      StdDraw.clear(StdDraw.WHITE);

      // generate N shapes as circles or rectangles based on circleProbability
      // and store them in the shapes array list
      int shapeCounter = 0;
      while (shapeCounter < N) {
         // generate random center coordinates in the range [0, 1) for the shape
         double xCenter = rGen.nextDouble(), yCenter = rGen.nextDouble();
         // generate a random value in the range [0, 1) for deciding on whether
         // to create a circle or a rectangle based on circleProbability
         double shapeType = rGen.nextDouble();
         // generate a circle if shapeType <= circleProbability
         if (shapeType <= circleProbability) {
            // generate a random radius value in the range [0, 0.1)
            double radius = rGen.nextDouble() / 10;
            // create the circle as a Circle object
            Circle c = new Circle(xCenter, yCenter, radius);
            // and add it to the shapes array list
            // (discarding the circle if its area is smaller than minArea)
            if (c.computeArea() >= minArea) {
               shapes.add(c);
               shapeCounter++; // increase the number of the created shapes
            }
         }
         // generate a rectangle otherwise
         else {
            // generate a random width and a random height in the range [0, 0.2)
            double width = rGen.nextDouble() / 5, height = rGen.nextDouble() / 5;
            // create the rectangle as a Rectangle object
            Rectangle r = new Rectangle(xCenter, yCenter, width, height);
            // and add it to the shapes array list
            // (discarding the rectangle if its area is smaller than minArea)
            if (r.computeArea() >= minArea) {
               shapes.add(r);
               shapeCounter++; // increase the number of the created shapes
            }
         }
      }

      // display each shape in the shapes array list
      for (Shape s : shapes) // using a for-each loop
         // using the draw method of the Shape class to dynamically invoke the
         // overridden draw method of the Circle class or the Rectangle class
         // at runtime depending on the type of the Shape s (polymorphism)
         s.draw();

      // sort the shapes in the array list in increasing order of their areas
      // (Collections.sort uses the compareTo method in the Shape class.)
      Collections.sort(shapes);

      // print the type and the area of each shape in the sorted array list
      for (Shape s : shapes) // using a for-each loop
         // using the toString method of either the Circle class or the Rectangle
         // class depending on the type of the Shape s (polymorphism)
         System.out.println(s);

      // highlight the largest shape (the last shape in the sorted array list)
      // by drawing it in color green
      shapes.get(N - 1).highlight(); // the highlight method of the Shape class

      // notify the user that the program is finished.
      System.out.println("Program finished.");
   }
}

// A superclass for modeling common properties of shapes (circles and rectangles).
abstract class Shape implements Comparable<Shape> {
   // Protected data fields that can be accessed from subclasses without using
   // public getter/setter methods
   protected double x; // center x-coordinate of the shape
   protected double y; // center y-coordinate of the shape
   protected Color color; // color of the shape

   // Constructor with input arguments
   protected Shape(double x, double y, Color color) {
      // using this keyword to distinguish instance data fields from parameters
      // both of which having same names
      this.x = x;
      this.y = y;
      this.color = color;
   }

   // A method for drawing shapes. As how to draw a shape depends on whether it
   // is a circle or a rectangle, the body of this method is empty and working
   // methods are implemented in subclasses by overriding this method.
   public abstract void draw();

   // A method to return the area of a shape. As how to calculate the area of the
   // shape depends on whether it is a circle or a rectangle, the body of this method is empty and working
   // methods are implemented in subclasses by overriding this method.
   public abstract double computeArea();

   // Overridden method to compare two shapes by looking at their areas.
   // If the first shape getting compared is bigger, method returns 1.
   // If the second shape getting compared is bigger, method returns -1.
   // If they have the same area, method returns 0.
   @Override
   public int compareTo(Shape s) {
      return Double.compare(this.computeArea(), s.computeArea());
   }

   // A method to highlight the shape by changing its color to green and drawing it
   public void highlight() {
      this.color = StdDraw.GREEN;
      this.draw();
   }

}

// A class for modeling circles as a subclass of the Shape class.
class Circle extends Shape {
   // A private data field
   private double radius; // radius of the circle

   // Constructor that creates a circle with given values for the data fields
   public Circle(double x, double y, double radius) {
      // superclass (Shape) constructor with parameters is invoked explicitly by
      // using super keyword and StdDraw.PRINCETON_ORANGE is used for the color
      super(x, y, StdDraw.PRINCETON_ORANGE);
      this.radius = radius; // setting the radius data field of the circle
   }

   // A method for computing and returning the area of the circle
   public double computeArea() {
      return Math.PI * radius * radius;
   }

   // A method for drawing the circle using StdDraw
   // It overrides the draw method in the superclass (Shape).
   public void draw() {
      // draw the circle with the specified color by accessing the protected
      // color, x and y data fields of the superclass (Shape)
      StdDraw.setPenColor(color);
      StdDraw.filledCircle(x, y, radius);
      // draw the boundary of the circle in color black
      StdDraw.setPenColor(StdDraw.BLACK);
      StdDraw.circle(x, y, radius);
      // draw the area with 3 decimal precision at the center of the circle
      // using the String.format method that returns a formatted string
      StdDraw.text(x, y, String.format("%.3f", computeArea()));
      // show the drawn circle by copying the offscreen canvas to onscreen and
      // waiting for a short time (double buffering)
      StdDraw.show();
      StdDraw.pause(100); // wait for 100 ms
   }

   // Overridden toString method to output circle with its area.
   @Override
   public String toString() {
      return "Circle: " + this.computeArea();
   }

}

// A class for modeling rectangles as a subclass of the Shape class.
class Rectangle extends Shape {
   // Private data fields
   private double width, height; // width and height of the rectangle

   // Constructor that creates a rectangle with given values for the data fields
   public Rectangle(double x, double y, double width, double height) {
      // superclass (Shape) constructor with parameters is invoked explicitly by
      // using super keyword and StdDraw.BOOK_LIGHT_BLUE is used for the color
      super(x, y, StdDraw.BOOK_LIGHT_BLUE);
      // setting width and height data fields of the rectangle
      this.width = width;
      this.height = height;
   }

   // A method for computing and returning the area of the rectangle
   public double computeArea() {
      return width * height;
   }

   // A method for drawing the rectangle using StdDraw
   // It overrides the draw method in the superclass (Shape).
   public void draw() {
      // draw the rectangle with the specified color by accessing the protected
      // color, x and y data fields of the superclass (Shape)
      StdDraw.setPenColor(color);
      StdDraw.filledRectangle(x, y, width / 2, height / 2);
      // draw the boundary of the rectangle in color black
      StdDraw.setPenColor(StdDraw.BLACK);
      StdDraw.rectangle(x, y, width / 2, height / 2);
      // draw the area with 3 decimal precision at the center of the rectangle
      // using the String.format method that returns a formatted string
      StdDraw.text(x, y, String.format("%.3f", computeArea()));
      // show the drawn rectangle by copying the offscreen canvas to onscreen
      // and waiting for a short time (double buffering)
      StdDraw.show();
      StdDraw.pause(100); // wait for 100 ms
   }

   // Overridden toString method to output rectangle with its area
   @Override
   public String toString() {
      return "Rectangle: " + this.computeArea();
   }

}