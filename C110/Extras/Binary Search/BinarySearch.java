import java.util.Arrays;

/**
 * Performs binary search in a sorted integer array
 */

public class BinarySearch {
	public static void main(String[] args) {

		int[] a = {1,3,4,6,8,9,13,20,22,31,48,67,88};
		System.out.println(Arrays.toString(a));
		int key = 48;
		int location = binarySearch(a, key); // search 48

		System.out.println();
		if (location == -1)
			System.out.println(key + " is not found.");
		else
			System.out.println(key + " is found at location " + location);
	}

	/**
	 * Performs binary search for a key in a sorted array.
	 * @param a Sorted array in increasing order
	 * @param key Key to be searched
	 * @return Location of the key in array. -1 if key is not found.
	 */
	private static int binarySearch(int[] a, int key) {
		int low = 0;
		int high = a.length-1;

		while (high >= low) {
			int middle = (high + low) / 2;
			System.out.printf("middle element a[" + middle + "] = " + a[middle] );
			if (a[middle] == key) {
				System.out.println(" key found!!!");
				return middle;
			}
			else if (key > a[middle]) {
				System.out.println(" search right part");
				low = middle + 1;
			}
			else {
				System.out.println(" search left part");
				high = middle - 1;
			}
		}
		return -1;
	}
}