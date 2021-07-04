import java.awt.Color;
import java.util.Random;

// A class that implements a 2D bouncing ball in a box from (-1, -1) to (1, 1).
// It also changes color randomly whenever it hits the canvas
public class Lab2 {
   public static void main(String[] args) {
      // StdDraw setup
      // ---------------------------------------------------------------------------
      // set the size of the drawing canvas
      StdDraw.setCanvasSize(500, 500);
      // set the scale of the coordinate system
      StdDraw.setXscale(-1.0, 1.0);
      StdDraw.setYscale(-1.0, 1.0);
      // double buffering is used for computer animations such as a bouncing ball
      // check https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html
      // for details
      StdDraw.enableDoubleBuffering();

      // properties of the ball
      double x = 0.480, y = 0.860; // initial position (center coordinates)
      double vx = 0.015, vy = 0.017; // initial speed
      double radius = 0.05; // radius
      // colors of the ball
      Color[] colors = {StdDraw.RED, StdDraw.GREEN, StdDraw.BLUE};
      Random rGen = new Random(); // random num generator
      StdDraw.setPenColor(StdDraw.BLACK); // set the first color for drawing the ball
 
      // main animation loop
      while (true) {
         // bounce the ball off the walls according to the law of elastic collision
         if (Math.abs(x + vx) > 1.0 - radius) { // the ball hits the left/right wall
            vx = -vx;// bounce the ball by reversing its speed in x-direction
            int randomIndex = rGen.nextInt(colors.length); // randomly pick a new color between the length of colors array
            StdDraw.setPenColor(colors[randomIndex]); // change to new random color
         }
         if (Math.abs(y + vy) > 1.0 - radius) { // the ball hits the top/bottom wall
            vy = -vy; // bounce the ball by reversing its speed in y-direction
            int randomIndex = rGen.nextInt(colors.length); // randomly pick a new color between the length of colors array
            StdDraw.setPenColor(colors[randomIndex]); // change to new random color
         }
         // update the position of the ball based on its speed
         x = x + vx;
         y = y + vy;

         // draw the ball in its current position at the end of each iteration of
         // the main animation loop
         // ------------------------------------------------------------------------
         // clear the offscreen drawing canvas (double buffering)
         StdDraw.clear(StdDraw.BOOK_LIGHT_BLUE);
         // draw the ball on the offscreen drawing canvas (double buffering)
         StdDraw.filledCircle(x, y, radius); // draw the ball as a filled circle
         // show the drawing by copying offscreen canvas to onscreen and waiting
         // for a short time (double buffering)
         StdDraw.show();
         StdDraw.pause(20); // pause for a short time (20 ms)
      }
   }
}