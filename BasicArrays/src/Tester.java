import java.util.Arrays;

public class Tester {
	
	/**
	 * Checks to see if the array is sorted
	 * Doesn't work for crappy sort because crappy sort overwrites values.
	 * @param a array check for sort
	 * @return true if sorted, false if not
	 */
	public static boolean checkSorted(int[] a) {
		for(int i=1; i<a.length; i++) {
			if(a[i]<a[i-1]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean checkCrappySort(int[] crappySortOutput, int[] mergeSortOutput) {
		return Arrays.equals(crappySortOutput, mergeSortOutput);
	}
	
	public static void main(String[] args) {
		//Crappy sort starts to take a painfully long time by the time you hit 1,000,000 elements (too long for me to let it finish). 
		//On my machine merge sort does 1 million elements in under 1 second.
		//If you want to see timing differences I would recommend running it with 500,000 elements. That way you don't get bored.
		//On my machine with 500k elements merge sort finished in 121 ms and crappy sort finished in 72525 ms.
		int length = 10;//Change this number to change the number of elements to sort
		ArrayOperators ops = new ArrayOperators();
		int[] randomArray = ops.createRandomArray(length);
		int[] mergeSortOutput = runMergeSort(randomArray);
		runCrappySort(randomArray, mergeSortOutput);
	}
	
	/**
	 * Runs the merge sort and times it, just for fun
	 * @param a array to sort
	 */
	public static int[] runMergeSort(int[] a) {
		ArrayOperators ops = new ArrayOperators();
		final long startTime = System.currentTimeMillis();
		int[] sortedArray = ops.mergeSort(a);
		final long endTime = System.currentTimeMillis();
		if(checkSorted(sortedArray)) {
			System.out.println("Merge sort finished in: " + (endTime - startTime) +" ms sorting "+a.length+" number of elements");
		}else {
			System.out.println("There was an error in merge sort. Failed to sort correctly. Tyler sucks");
		}
		return sortedArray;
	}
	
	/**
	 * Runs the crappy sort and times it, just for fun
	 * @param a array to sort
	 */
	public static void runCrappySort(int[] a, int[] mergeSortOutput) {
		ArrayOperators ops = new ArrayOperators();
		final long startTime = System.currentTimeMillis();
		int[] sortedArray = ops.crappySort(a);
		final long endTime = System.currentTimeMillis();
		if(checkCrappySort(sortedArray, mergeSortOutput)) {
			System.out.println("Crappy sort finished in: " + (endTime - startTime) +" ms sorting "+a.length+" number of elements");
		}else {
			System.out.println("There was an error in crappy sort. Sorting failed");
		}
	}
}
