import java.util.ArrayList;
import java.util.Random; // import Random class for generating random values
import java.util.Scanner;

// Class implementing a randomly initialized bouncing ball in a 2D box.
public class Lab5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StdDraw.setCanvasSize(500, 500); // set the size of the drawing canvas
        StdDraw.setScale(-1, 1); // set both x and y scales to the range [-1, 1]
        // double buffering enables computer animations, creating an illusion of
        // motion by repeating four steps: clear, draw, show and pause
        StdDraw.enableDoubleBuffering();
        System.out.print("Enter the amount of balls to draw: ");
        int numberOfBalls = input.nextInt();
        int currentBalls = 0;
        ArrayList<Lab5_Ball> balls = new ArrayList<Lab5_Ball>();
        double x, y, vx, vy, r = 0.03; // properties of the ball
        Random random = new Random(); // a random number generator is created
        while(currentBalls < numberOfBalls){
            // generate random x and y coordinates for the ball's position by using
            // do while loops to ensure that the ball is totally inside the canvas
            do {
                x = random.nextDouble() * 2 - 1; // x-coordinate between -1 and 1
            } while (Math.abs(x) > 1 - r);
            do {
                y = random.nextDouble() * 2 - 1; // y-coordinate between -1 and 1
            } while (Math.abs(y) > 1 - r);
            // generate x and y components of the ball's speed randomly
            vx = (random.nextDouble() * 2 - 1) / 50; // x-speed between -0.05 and 0.05
            vy = (random.nextDouble() * 2 - 1) / 50; // y-speed between -0.05 and 0.05
            balls.add(new Lab5_Ball(x,y,vx,vy,r));
            currentBalls++;
        }

        // the main animation loop
        while (true) {
            for (int i = 0; i < numberOfBalls; i++) {
            // bounce the ball off the walls based on the law of elastic collision
            if (Math.abs(balls.get(i).x + balls.get(i).vx) > 1 - balls.get(i).r) // if the ball hits the left/right wall
                balls.get(i).vx = -balls.get(i).vx; // bounce the ball by reversing its speed in x-direction
            if (Math.abs(balls.get(i).y + balls.get(i).vy) > 1 - balls.get(i).r) // if the ball hits the top/bottom wall
                balls.get(i).vy = -balls.get(i).vy; // bounce the ball by reversing its speed in y-direction
            // update the position of the ball based on its speed
                balls.get(i).x = balls.get(i).x + balls.get(i).vx;
                balls.get(i).y = balls.get(i).y + balls.get(i).vy;

            }
            // clear the offscreen canvas to color StdDraw.BOOK_LIGHT_BLUE
            StdDraw.clear(StdDraw.BOOK_LIGHT_BLUE);
            // draw the ball at its current position on the offscreen canvas
            StdDraw.setPenColor(StdDraw.BLACK); // set the color for drawing
            for(Lab5_Ball ball : balls)
                ball.draw();
            // show the drawing by copying the offscreen canvas to onscreen
            StdDraw.show();
            StdDraw.pause(20); // and waiting for a short time (20 ms)
        }

    }
}