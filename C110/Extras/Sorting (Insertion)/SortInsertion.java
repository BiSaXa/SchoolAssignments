import java.util.Arrays;


/**
 * Sort an array in increasing order. Starting from
 * the beginning of the array, insert current element
 * into the sorted (left) part of the array.
 *
 */
public class SortInsertion {

	public static void main(String[] args) {
		int[] inputArray = {2,9,5,4,8,-4,1,6,-1};
		System.out.println("Initial array contents: " + Arrays.toString(inputArray));
		sortAlgorithm(inputArray);
		System.out.println("Sorted array contents : " + Arrays.toString(inputArray));
	}

	/**
	 * Sorts integers in increasing order.
	 * Inserts a[i] into a sorted sublist a[0..i-1]
	 *
	 * @param array Input array to be sorted
	 */
	private static void sortAlgorithm(int[] array) {

		// Insert a[i] into a sorted sublist a[0..i-1]
		for (int i = 1; i < array.length; i++) {
			int currentElement = array[i];
			int j;
			// Move from (i-1)th location towards the beginning of the array
			for (j = i-1; j >= 0; j--)
				// If jth element is greater than currentElement, 
				// move the jth element one position to the right
				if (array[j] > currentElement)
					array[j+1] = array[j];
				else 
					// Else, if jth element is smaller than the current element, 
					// exit from the loop and store current element to (j+1)th location 
					break;
			array[j+1] = currentElement;
		}
	}
}