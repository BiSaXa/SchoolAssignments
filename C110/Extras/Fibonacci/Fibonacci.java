import java.util.Scanner;

public class Fibonacci {

		/**
     * listFibonacci: fibonacci sequence algorithm that utilizes large array approach
     * @param nthFibonacciNumber sought fibonacci number
     * @return nth fibonacci number
     */
    public static int listFibonacci(int nthFibonacciNumber){
        if(nthFibonacciNumber == 0){
            return 0;
        }
        int[] fibonacciArray = new int[nthFibonacciNumber + 1];
        fibonacciArray[1] = 1;
				//storing every single element inside the array
				//space inefficient
        for(int i = 2; i < nthFibonacciNumber + 1; i++){
            fibonacciArray[i] = fibonacciArray[i-1] + fibonacciArray[i - 2];
        }
        return fibonacciArray[nthFibonacciNumber];
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(listFibonacci(n));
    }

}
/* Circular array approach

import java.util.Scanner;

public class Fibonacci {

    public static long fibonacci(int nthFibonacciNumber){
        //if cases for 0, 1 and 2
        if (nthFibonacciNumber == 0)
            return 0;
        if (nthFibonacciNumber == 1 || nthFibonacciNumber == 2)
            return 1;

        long[] fibonacciArray = new long[3];
        //first 2 elements to calculate fibonacci sequence
        fibonacciArray[0] = 1;
        fibonacciArray[1] = 1;
        int counter = 2;
        while(counter <= nthFibonacciNumber){
            fibonacciArray[counter % 3] = fibonacciArray[(counter - 2) % 3] + fibonacciArray[(counter - 1) % 3];
            counter++;
        }
        return fibonacciArray[(nthFibonacciNumber - 1) % 3];
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(fibonacci(n));
    }

}

*/