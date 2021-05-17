import java.awt.*;
import java.util.Scanner;

public class RootGraph {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("ax^3 + bx^2 + c^x + d");
        System.out.println("Enter the a, b, c, d values: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();

        System.out.println("For bisection enter the A, B and Tolerance: ");
        double x1 = input.nextDouble();
        double x2 = input.nextDouble();
        double tolerance = input.nextDouble();

        Function function = new Function(a, b, c, d);
        function.canvas();
        //x1 = A value, x2 = B value, tolerance = tolerance
        double bisection = function.bisection_method(x1, x2, tolerance);
        function.functionPlot(bisection);
        System.out.println("Answer: " + bisection);
        input.close();
    }

}

class Function{

    // a x^3 + b x^2 + c x + d
    double a;
    double b;
    double c;
    double d;

    Function(double a, double b, double c, double d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    double function(double x){
        double k = a * Math.pow(x, 3);
        double l = b * Math.pow(x, 2);
        double n = c * x + d;

        return k + l + n;
    }

    /**
     * func_derivative: returns the derivative values of the function
     * @param x: x value of the function
     * @return derivative of the function
     */

    double func_derivative(double x){
        return 3 * a * Math.pow(x, 2) + b * x + c;
    }

    /**
     * sign: Returns the sign
     * @param x: x value
     * @return sign
     */
    double sign(double x){
        if(x >= 0)
            return 1;
        return -1;
    }

    /**
     * bisection_method: Uses bisection method to calculate the bisections.
     * @param x1: A value
     * @param x2: B value
     * @param tolerance: acceptable region value
     * @return midpoint
     */

    double bisection_method(double x1, double x2, double tolerance){
        double midpoint;
        int counter = 0;
        do {
            midpoint = x1 + (x2 - x1) / 2;
            System.out.println(counter + "\t a: " + x1 + "\t\t b: " + x2 + "\t\t midpoint: "
                    + midpoint + "\t\t f(midpoint): " + function(midpoint));
            /*
            Use x1 + (x2 - x1) to protect from underflow error.
            If the sign of a and sign of midpoint are equal, change x1's value to midpoint
            If the sign of a and the sign of midpoint are not equal, change x2's value to midpoint
             */
            if (sign(function(x1)) == sign(function(midpoint)))
                x1 = midpoint;
            else
                x2 = midpoint;
            counter++; // iteration number

        }while(Math.abs(x2 - x1) > tolerance);
        System.out.println("Bisection counter: " + counter);
        return midpoint;
    }

    /**
     * canvas: setting canvas size, x and y scale
     */

    void canvas(){

        int width = 600;
        int height = 600;
        StdDraw.setCanvasSize(width, height);

        StdDraw.setXscale(-90, 90);
        StdDraw.setYscale(-90, 90);

        //Drawing x=0 and y=0 lines

        StdDraw.line(0, -90, 0, 90);
        StdDraw.line(-90,0, 90, 0);

        StdDraw.enableDoubleBuffering();

    }

    /**
     * functionPlot: plots the function to the canvas
     * @param bisection: bisection x coordinate
     */

    void functionPlot(double bisection){

        //starting from x=-90
        int startPoint = -90;

        for(int i = -90; i <= 90; i++){

            //finding y coordinates
            double point = function(startPoint);
            double point2 = function(startPoint + 1);
            StdDraw.line(i, point, i + 1, point2);
            startPoint++;

        }

        //plotting the bisection point
        StdDraw.setPenColor(Color.RED);
        StdDraw.filledCircle(bisection, function(bisection), 1);

        StdDraw.show();

    }

}