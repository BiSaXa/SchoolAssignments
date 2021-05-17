import java.util.Arrays;

/**
 * Sort an array in increasing order.
 * Algorithm starts from the beginning of the array and
 * replaces the current element with the smallest value
 * found in the rest of the array
 *
 */
public class SortArray {
	public static void main(String[] args) {
		
		double[] inputArray  = {4.6, 0.2, 9.3, -1.2, 0.01, 7.1, 2.1, -9.8};
		
		// currentPosition starts from the beginning and iterates until array length-2
		for (int currentPosition = 0; currentPosition <= inputArray.length-2; currentPosition++) {
			
			System.out.println("\nCurrent Position: " + currentPosition +
					", Current Element: " + inputArray[currentPosition]);
			System.out.println(Arrays.toString(inputArray));

			// store the current element in a variable
			double currentElement = inputArray[currentPosition];
			
			// find the smallest element in the rest of the array
			// minVal will be the minimum value in the rest of the array
			double minVal = inputArray[currentPosition+1];
			// minIndex stores the index location of minVal
			int minIndex = currentPosition + 1;
			for (int i = currentPosition+2; i < inputArray.length; i++)
				// if the ith element is smaller than minVal, update minVal and minIndex
				if (inputArray[i] < minVal) {
					minVal = inputArray[i];
					minIndex = i;
				}
			// swap currentElement with minVal if minVal is smaller than currentElement
			if (minVal < currentElement) {
				inputArray[currentPosition] = minVal;
				inputArray[minIndex] = currentElement;
			}
			System.out.println(Arrays.toString(inputArray));
		}
	}
}