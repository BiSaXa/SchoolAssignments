import java.util.*;

// A program for comparing execution times of some sorting algorithms while they
// are used for sorting integer arrays with different sizes in increasing order.
public class CompareSortingTimes {
   public static void main(String[] args) {
      // test the implementations for different sorting algorithms
      // -----------------------------------------------------------------------
      // an array to be sorted
      int[] testArray = { 331, 454, 230, 34, 343, 45, 59, 453, 345, 231, 9 };
      // the number of the digits of the largest element in the array
      int digits = 3; // needed for using radix sort
      // invoke the method that sorts the given array using different sorting
      // algorithm implementations
      testSortingImplementations(testArray, digits);
      System.out.println(); // print an additional new line
      System.out.println("  Array | Selection Insertion    Bubble     Merge     Quick     Heap      Radix");
      System.out.println("   Size |      Sort      Sort      Sort      Sort      Sort     Sort       Sort");
      System.out.println("--------------------------------------------------------------------------------");
      Random random = new Random();
      int[] array;
      for (int size = 1; size <= 10; size++) {
         array = new int[size * 10000];
         for (int index = 0; index < array.length; index++) {
            array[index] = random.nextInt(1000000);
         }
         if (size != 10)
            System.out.print("  " + size * 10000 + " |");
         else
            System.out.println(" " + size * 10000 + " |");
         long start = System.currentTimeMillis();
         for (int n = 0; n < 10; n++) {
            int[] toSort = new int[array.length];
            System.arraycopy(array, 0, toSort, 0, array.length);
            selectionSort(toSort);
         }
         long end = System.currentTimeMillis();
         long time = (end - start) / 10;
         printSpaced(time, end, start);
         start = System.currentTimeMillis();
         for (int n = 0; n < 10; n++) {
            int[] toSort = new int[array.length];
            System.arraycopy(array, 0, toSort, 0, array.length);
            insertionSort(toSort);
         }
         end = System.currentTimeMillis();
         time = (end - start) / 10;
         printSpaced(time, end, start);
         start = System.currentTimeMillis();
         for (int n = 0; n < 10; n++) {
            int[] toSort = new int[array.length];
            System.arraycopy(array, 0, toSort, 0, array.length);
            bubbleSort(toSort);
         }
         end = System.currentTimeMillis();
         time = (end - start) / 10;
         printSpaced(time, end, start);
         start = System.currentTimeMillis();
         for (int n = 0; n < 10; n++) {
            int[] toSort = new int[array.length];
            System.arraycopy(array, 0, toSort, 0, array.length);
            mergeSort(toSort);
         }
         end = System.currentTimeMillis();
         time = (end - start) / 10;
         printSpaced(time, end, start);
         start = System.currentTimeMillis();
         for (int n = 0; n < 10; n++) {
            int[] toSort = new int[array.length];
            System.arraycopy(array, 0, toSort, 0, array.length);
            quickSort(toSort);
         }
         end = System.currentTimeMillis();
         time = (end - start) / 10;
         printSpaced(time, end, start);
         start = System.currentTimeMillis();
         for (int n = 0; n < 10; n++) {
            int[] toSort = new int[array.length];
            System.arraycopy(array, 0, toSort, 0, array.length);
            heapSort(toSort);
         }
         end = System.currentTimeMillis();
         time = (end - start) / 10;
         printSpaced(time, end, start);
         start = System.currentTimeMillis();
         for (int n = 0; n < 10; n++) {
            int[] toSort = new int[array.length];
            System.arraycopy(array, 0, toSort, 0, array.length);
            radixSort(toSort, digits);
         }
         end = System.currentTimeMillis();
         time = (end - start) / 10;
         printSpaced(time, end, start);
         System.out.println();
      }
   }

   private static void printSpaced(long time, long end, long start) {
      String p = time + "." + (end - start) % 10 + "0";
      switch (p.length()) {
         case 4:
            System.out.print("      " + p);
            break;
         case 5:
            System.out.print("     " + p);
            break;
         case 6:
            System.out.print("    " + p);
            break;
         case 7:
            System.out.print("   " + p);
            break;
         case 8:
            System.out.print("  " + p);
            break;
         default:
            System.out.print(" " + p);
            break;
      }
   }

   // Method for testing different sorting algorithm implementations
   // --------------------------------------------------------------------------
   public static void testSortingImplementations(int[] list, int numDigits) {
      // create an integer array to preserve the contents of the given array for
      // using the same array with different sorting algorithm implementations
      int[] toSort = new int[list.length];
      // print the given array before sorting
      System.out.println("Array before sorting: " + Arrays.toString(list));
      // use each sorting algorithm implementation for sorting the array and
      // print the array after it is sorted
      String[] names = { "Selection", "Insertion", "Bubble", "Merge", "Quick", "Heap", "Radix" };
      for (int i = 0; i < 7; i++) {
         // copy the contents of the given array list to the array toSort
         System.arraycopy(list, 0, toSort, 0, list.length);
         // select the sorting algorithm to use based on the value of i
         switch (i) {
         case 0:
            selectionSort(toSort);
            break;
         case 1:
            insertionSort(toSort);
            break;
         case 2:
            bubbleSort(toSort);
            break;
         case 3:
            mergeSort(toSort);
            break;
         case 4:
            quickSort(toSort);
            break;
         case 5:
            heapSort(toSort);
            break;
         case 6:
            radixSort(toSort, numDigits);
         }
         // print the sorted array
         System.out.println(names[i] + " sort: " + Arrays.toString(toSort));
      }
   }

   // Selection sort implementation
   // --------------------------------------------------------------------------
   public static void selectionSort(int[] list) {
      // repeat for list.length - 1 times
      for (int i = 0; i < list.length - 1; i++) {
         // find the minimum number in the range [i, list.length - 1]
         int currentMin = list[i], currentMinIndex = i;
         for (int j = i + 1; j < list.length; j++) {
            if (currentMin > list[j]) {
               currentMin = list[j];
               currentMinIndex = j;
            }
         }
         // swap list[i] with list[currentMinIndex] if necessary
         if (currentMinIndex != i) {
            list[currentMinIndex] = list[i];
            list[i] = currentMin;
         }
      }
   }

   // Insertion sort implementation
   // --------------------------------------------------------------------------
   public static void insertionSort(int[] list) {
      // from the index 1 to the end of the given array
      for (int i = 1; i < list.length; i++) {
         // insert list[i] into the sorted sublist list[0 ... i - 1] to obtain
         // a sorted list[0 ... i]
         int currentElement = list[i], k;
         // traversing the sorted sublist backward (from larger values to smaller)
         for (k = i - 1; k >= 0 && list[k] > currentElement; k--)
            // shifting the larger numbers in the sorted sublist to the right
            list[k + 1] = list[k];
         // inserting the current element into the slot list[k + 1]
         list[k + 1] = currentElement;
      }
   }

   // Bubble sort implementation
   // --------------------------------------------------------------------------
   public static void bubbleSort(int[] list) {
      // a boolean variable that shows whether another pass is needed or not
      boolean needNextPass = true;
      // compare and order pairs of adjacent elements sequentially until another
      // pass is not needed or list.length - 1 passes are made
      for (int k = 1; k < list.length && needNextPass; k++) {
         needNextPass = false;
         for (int i = 0; i < list.length - k; i++) {
            // compare each pair of adjacent elements
            if (list[i] > list[i + 1]) {
               // swap list[i] with list[i + 1]
               int temp = list[i];
               list[i] = list[i + 1];
               list[i + 1] = temp;
               // another pass is necessary as a swap is made
               needNextPass = true;
            }
         }
      }
   }

   // Merge sort implementation
   // --------------------------------------------------------------------------
   public static void mergeSort(int[] list) {
      // a recursive approach that continues until a single element remains
      // in the given array
      if (list.length > 1) {
         // apply merge sort to the first half of the given array
         int[] firstHalf = new int[list.length / 2];
         System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
         mergeSort(firstHalf);
         // apply merge sort to the second half of the given array
         int secondHalfLength = list.length - list.length / 2;
         int[] secondHalf = new int[secondHalfLength];
         System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
         mergeSort(secondHalf);
         // merge the sorted halves into the given array itself
         merge(firstHalf, secondHalf, list);
      }
   }

   // method for merging the sorted halves into a given single array (merged)
   // such that the array merged is sorted
   public static void merge(int[] half1, int[] half2, int[] merged) {
      int current1 = 0; // current index in half1
      int current2 = 0; // current index in half2
      int current3 = 0; // current index in merged
      // compare each element in the two sorted halves sequentially
      while (current1 < half1.length && current2 < half2.length) {
         // place the smaller element into the merged array
         if (half1[current1] < half2[current2])
            merged[current3++] = half1[current1++];
         else
            merged[current3++] = half2[current2++];
      }
      // add the remaining elements in half1 to the merged array when there is
      // no remaining element in half2
      while (current1 < half1.length)
         merged[current3++] = half1[current1++];
      // add the remaining elements in half2 to the merged array when there is
      // no remaining element in half1
      while (current2 < half2.length)
         merged[current3++] = half2[current2++];
   }

   // Quick sort implementation
   // --------------------------------------------------------------------------
   public static void quickSort(int[] list) {
      // invoke the recursive quickSort(int[] list, int first, int last) method
      // to sort the given array
      quickSort(list, 0, list.length - 1);
   }

   // recursive method for sorting a part of a given array bounded by the given
   // indexes first and last
   public static void quickSort(int[] list, int first, int last) {
      // recursive sorting continues as long as first is smaller than last
      // (there are at least 2 elements)
      if (last > first) {
         // split the part of the given array bounded by first and last into
         // two subparts and get the pivot index that splits the two subparts
         int pivotIndex = partition(list, first, last);
         // apply quick sort for each subpart (partition) around the pivot index
         quickSort(list, first, pivotIndex - 1);
         quickSort(list, pivotIndex + 1, last);
      }
   }

   // method that partitions a part of a given array bounded by first and last
   // into two subparts (partitions) around a pivot index such that all numbers
   // before the pivot index are smaller than the pivot value and all numbers
   // after the pivot index are larger than the pivot value
   public static int partition(int[] list, int first, int last) {
      int pivot = list[first]; // the first element is chosen as the pivot
      int low = first + 1; // index for forward search
      int high = last; // index for backward search
      // continue as long as low is smaller than high
      while (high > low) {
         // search forward from left
         while (low <= high && list[low] <= pivot)
            low++; // keeping lower values on the left partition
         // search backward from right
         while (low <= high && list[high] > pivot)
            high--; // keeping higher values on the right partition
         // swap the elements indexed with low and high whenever it is needed
         // (to keep lower values on the left partition and higher values on the
         // right partition)
         if (high > low) {
            int temp = list[high];
            list[high] = list[low];
            list[low] = temp;
         }
      }
      // find the slot for placing the pivot element, swap the pivot element
      // list[first] with list[high] if needed and return its index
      while (high > first && list[high] >= pivot)
         high--; // keeping higher values on the right partition (if any)
      if (pivot > list[high]) {
         list[first] = list[high];
         list[high] = pivot;
         return high;
      } else {
         // the case when all the values are larger than the pivot element
         return first;
      }
   }

   // Heap sort implementation
   // --------------------------------------------------------------------------
   public static void heapSort(int[] list) {
      // create a heap
      Heap heap = new Heap();
      // add each number in the given array to the heap
      for (int i = 0; i < list.length; i++)
         heap.add(list[i]);
      // remove each number from the heap and place the number to the given array
      for (int i = 0; i < list.length; i++)
         list[i] = heap.remove();
   }

   // a class that implements a min heap data structure storing integer values
   // (only the needed parts for the heapSort method are included)
   static class Heap {
      // an array list for storing the elements in the heap
      private ArrayList<Integer> list = new ArrayList<>();

      // method for adding a new integer to the heap
      public void add(int newValue) {
         // add the given integer to the heap as the last heap node
         list.add(newValue); // appending newValue to the internal array list
         // rebuild the tree by continuously swapping the newly added node with
         // its parent as needed (currentIndex is initialized with the index of
         // the last node which is the newly added node)
         int currentIndex = list.size() - 1;
         while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            // swap if the current node has a smaller value than its parent
            if (list.get(currentIndex) < list.get(parentIndex)) {
               int temp = list.get(currentIndex);
               list.set(currentIndex, list.get(parentIndex));
               list.set(parentIndex, temp);
            } else
               break; // the tree is a heap now (no more swap is necessary)
            // update the index of the current node after each swap
            currentIndex = parentIndex;
         }
      }

      // method for removing the root node from the heap and returning its value
      public int remove() {
         // throw a NoSuchElementException if the heap is empty
         if (list.size() == 0)
            throw new NoSuchElementException("The heap is empty.");
         // store the value of the root node to return after it is removed
         int removedValue = list.get(0);
         // replace the root node with the last node
         list.set(0, list.get(list.size() - 1));
         // remove the last node from the heap
         list.remove(list.size() - 1);
         // rebuild the tree by continuously swapping the current node with its
         // smaller child as needed starting from the root node
         int currentIndex = 0;
         while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;
            // find the smaller between the two child nodes
            if (leftChildIndex >= list.size())
               // the tree is a heap now (no child exists for the current node)
               break;
            // the index of the smaller child node is initialized as the index of
            // the left child node
            int minIndex = leftChildIndex;
            // if there is a right child node
            if (rightChildIndex < list.size())
               // assign the index of the right child node to minIndex if its
               // value is smaller than the value of the left child node
               if (list.get(minIndex) > list.get(rightChildIndex))
                  minIndex = rightChildIndex;
            // swap if the current node is greater than the smaller child node
            if (list.get(currentIndex) > list.get(minIndex)) {
               int temp = list.get(minIndex);
               list.set(minIndex, list.get(currentIndex));
               list.set(currentIndex, temp);
               // update the index of the current node
               currentIndex = minIndex;
            } else
               break; // the tree is a heap now (no more swap is necessary)
         }
         // return the value of the removed root node
         return removedValue;
      }
   }

   // Radix sort implementation
   // --------------------------------------------------------------------------
   // numDigits is the number of the digits of the largest number in the array
   public static void radixSort(int[] list, int numDigits) {
      // create an array list for each bucket (digit value)
      ArrayList<Integer>[] buckets = new ArrayList[10];
      for (int i = 0; i < buckets.length; i++)
         buckets[i] = new ArrayList<Integer>();
      // apply bucket sort for each digit starting from the rightmost digit
      for (int position = 0; position <= numDigits; position++) {
         // clear the buckets
         for (int i = 0; i < buckets.length; i++)
            buckets[i].clear();
         // distribute the numbers in the array (list) to the buckets
         // based on the values at the current digit position
         for (int i = 0; i < list.length; i++) {
            int key = getKey(list[i], position);
            buckets[key].add(list[i]);
         }
         // move the elements from the buckets back to the array (list)
         int k = 0; // current index for the array (list)
         // traverse each bucket forward
         for (int i = 0; i < buckets.length; i++)
            if (buckets[i] != null)
               // move all the elements in the bucket to the array (list)
               for (int j = 0; j < buckets[i].size(); j++)
                  list[k++] = buckets[i].get(j);
      }
   }

   // method that returns the value at the given position (digit) of the given
   // number (the position of the last digit is zero)
   public static int getKey(int number, int position) {
      int digitValue = (number / (int) Math.pow(10, position)) % 10;
      return digitValue;
   }
}