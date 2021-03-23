import java.util.Arrays;

public class Lab1 {

    public static void main(String[] args) {
    	// 4 different test cases for testing the findBigElements method
		// These arrays were given to us
        int[] inputArray = { 12, 4, 4, 3, 12, 4, 8, 3 }; // Test Case 1
        //int[] inputArray = { 4, 4, 4 }; // Test Case 2
        //int[] inputArray = { 8 }; // Test Case 3
        //int[] inputArray = { 2, 4, 6, 8, 10 }; // Test Case 4

        System.out.println("Finding Bigger Elements");
        // using findBigElements method to get the bigger elements for inputArray
        int[] bigArray = findBigElements(inputArray);
        // displaying the contents of inputArray and bigArray on the console by
        // using the Arrays.toString method that returns a String representation
        // for the contents of a given array
        System.out.println("Input Array: " + Arrays.toString(inputArray));
        System.out.println("Bigger Array: " + Arrays.toString(bigArray));
    }
    
    public static int[] findBigElements(int[] input_array) {
    	int[] temp_array = new int[32768];
    	int sum = 0;
    	double avg = 0;
    	int j = 0;
    	for(int i = 0; i < input_array.length; i++) {
    		sum += input_array[i];
    	}
    	avg = (double)sum/input_array.length;
    	System.out.printf("Array Average : %.2f\n", avg);
    	for(int i = 0; i < input_array.length; i++) {
    		if(input_array[i] > avg) {
    			temp_array[j] = input_array[i];
    			j++;
    		}
    	}
    	int[] output_array = new int[j];
    	for(int i = 0; i < output_array.length; i++) {
    		output_array[i] = temp_array[i];
    	}
    	if(j != 0) {
    		return output_array;
    	}else {
    		return null;
    	}
		
    }
    
}