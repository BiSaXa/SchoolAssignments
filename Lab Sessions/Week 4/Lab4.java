import java.util.Random;
import java.util.Scanner;

public class Lab4 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = in.nextInt(); // Input number of total circle count
        in.close();

        int canvasWidth = 600, canvasHeight = 600; // StdDraw init
        StdDraw.setCanvasSize(canvasWidth, canvasHeight);
        StdDraw.setScale(0, 1);

        Lab4_MyCircle[] circles = new Lab4_MyCircle[N];
        Random randomGenerator = new Random(); // Create an RNG
        double rMin = 0.01, rMax = 0.2;

        int circleCount = 0;
        while (circleCount < N) {
            // create a random radius value in the range [rMin, rMax)
            double r = rMin + (rMax - rMin) * randomGenerator.nextDouble();
            // create random x and y ensuring the whole circle is in the canvas
            double x = r + (1 - 2 * r) * randomGenerator.nextDouble();
            double y = r + (1 - 2 * r) * randomGenerator.nextDouble();
            Lab4_MyCircle newCircle = new Lab4_MyCircle(x, y, r); // Creating circle
            boolean overlap = false;
            for (Lab4_MyCircle storedCircle : circles) {
                // for-each loop
                if(storedCircle == null)
                    break;
                double r1 = newCircle.getRad(), r2 = storedCircle.getRad();
                if (newCircle.computeDistance(storedCircle) < (r1 + r2)) {
                    overlap = true;
                    break; // end the loop as an overlap is detected
                }
            }
            // recreate the random circle (newCircle) if an overlap is detected
            if (overlap)
                continue; // continue from the next iteration of the while loop
            circles[circleCount] = newCircle;
            circleCount++; // increase the number of non-overlapping circles by 1
            newCircle.draw(); // drawing the final circle
        }
    }
}
