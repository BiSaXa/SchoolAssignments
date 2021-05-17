import java.util.Arrays;

/**
 * Reverse array contents
 *
 */
public class ReverseArray {
	public static void main(String[] args) {
		int[] a = {5,8,1,6,3,2,4,0};
		int[] output = reverse(a);
		System.out.println("Input array   : " + Arrays.toString(a));
		System.out.println("Reversed array: " + Arrays.toString(output));
	}

	/**
	 * Reverses array contents
	 * @param inputArray Input array
	 * @return Reversed array
	 */
	private static int[] reverse(int[] inputArray) {
		int[] result = new int[inputArray.length];
		int middle = inputArray.length/2;
		for (int i = 0; i < middle; i++) {
			result[i] = inputArray[inputArray.length-i-1];
			result[inputArray.length-i-1] = inputArray[i];
		}
		return result;
	}
}