import java.util.Scanner;

public class Root {

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
        //x1 = A value, x2 = B value, tolerance = tolerance
        double bisection = function.bisection_method(x1, x2, tolerance);
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

    double func(double x){
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
		 * if you are reading this, you are awesome!
     * @return midpoint
     */

    double bisection_method(double x1, double x2, double tolerance){
        double midpoint;
        int counter = 0;
        do {
            midpoint = x1 + (x2 - x1) / 2;
            System.out.println(counter + "\t a: " + x1 + "\t\t b: " + x2 + "\t\t midpoint: "
                    + midpoint + "\t\t f(midpoint): " + func(midpoint));
            /*
            Use x1 + (x2 - x1) to protect from underflow error.
            If the sign of a and sign of midpoint are equal, change x1's value to midpoint
            If the sign of a and the sign of midpoint are not equal, change x2's value to midpoint
             */
            if (sign(func(x1)) == sign(func(midpoint)))
                x1 = midpoint;
            else
                x2 = midpoint;
            counter++; // iteration number

        }while(Math.abs(x2 - x1) > tolerance);
        System.out.println("Bisection counter: " + counter);
        return midpoint;
    }

}