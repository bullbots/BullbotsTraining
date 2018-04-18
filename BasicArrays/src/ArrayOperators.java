import java.util.Arrays;
import java.util.Random;

public class ArrayOperators {
	
	/**
	 * Prints the array out with a space between each element of the array
	 * @param a the integer array to print out
	 * @return a string to print out that represents the integer array.
	 */
	public String printArray(int[] a) {
		String returnValue = "";//Start with empty array
		for(int i=0; i<a.length; i++) {//Start at i=0 and go until i = a.length-1 (or i<a.length), increment i each time
			returnValue += a[i] + " ";//This is called concatenation. Google it and play around with it a little bit.
			//Basically it APPENDS strings to each other. So if I concatentate the strings "First string" and "Second string"
			//I get "First stringSecondString" (yes with no space in between);
		}
		return returnValue;//Return the string that represents the array.
	}
	
	/**
	 * This adds the values at each indexes of the arrays together.
	 * Example:
	 * a = {1, 2, 3};
	 * b = {4, 5, 6};
	 * addArrays(a, b) returns a new array {5, 7, 9};
	 * @param a the first array to add
	 * @param b the second array to add
	 * @return an integer array that is the sum of the two at each index.
	 */
	public int[] addArrays(int[] a, int[] b) {
		int[] d = new int[a.length];
		for (int i = 0;i <a.length; i++) {
			d[i] = a[i] + b[i];
		}
		return d;
	}
	
	
	/**
	 * Similar to addArrays but subtracts
	 * @param a first array to subtract
	 * @param b second array to subtract
	 * @return an integer array that is the difference of the two at each index
	 */
	public int[] funSubtract(int[] a, int[] b) {
		int[] e = new int[a.length];
		for(int i = 0; i <a.length; i++) {
			e[i] = a[i] + b[b.length -1 - i];
		}
		return e;
	}
	/**
	 * This is a "crappy sort method", which just means it's really slow.
	 * This is also NOT finished, there is a bug in it.
	 * 
	 * Example:
	 * a = { 3, 2, 1}
	 * we want to output a new array = {1, 2, 3}
	 * 
	 * Think specifically about how crappy sort is determining the smallest value - and what it DOES to the index where that value 
	 * is located in array a.
	 * @param a array to sort in increasing order
	 * @return a sorted array in increasing order
	 */
	public int[] crappySort(int[] a) {
		int[] result= new int[a.length];
		for(int i=0; i<a.length; i++) {
			int smallest=Integer.MAX_VALUE;
			for(int j=0; j<a.length; j++) {
				if(smallest>a[j]) {
					smallest = a[j];
				}
			}
			result[i] = smallest;
		}
		
		return result;
	}
	
	/**
	 * This is a pretty good sorting algorithm (merge sort - not optimized).
	 * Take a look at it and try to understand it if you're curious.
	 * Bonus to anyone who can code up something that sorts faster than this (try radix sort).
	 * @param a array to sort
	 * @param p bottom index of array
	 * @param r top index of array
	 * @return sorted array
	 */
	public int[] mergeSort(int[] a) {
		if(a.length>1) {
			int q = (a.length-1)/2;
			int[] left = mergeSort(Arrays.copyOfRange(a, 0, q+1));
			int[] right = mergeSort(Arrays.copyOfRange(a, q+1, a.length));
			if(left==null && right == null) {
				return null;
			}
			if(left == null) {
				return right;
			}
			if(right == null) {
				return left;
			}
			
			return merge(left, right);
		}else {
			return a;
		}
		
	}
	
	/**
	 * Does the merge part of merge sort
	 * @param a left array to merge
	 * @param b right array to merge
	 * @return merged array
	 */
	private int[] merge(int[] a, int[] b) {
		int[] merged = new int[a.length+b.length];
		int k=0, i=0, j=0;
		while(i<a.length && j<b.length) {
			if(a[i]<=b[j]){
				merged[k++]=a[i++];
			}else {
				merged[k++]=b[j++];
			}
		}
		
		while(i<a.length) {
			merged[k++]=a[i++];
		}
		while(j<b.length) {
			merged[k++]=b[j++];
		}
		
		return merged;
	}
	
	/**
	 * Creates a random array
	 * @param length the length of the array to create
	 * @return a new int array with random values.
	 */
	public static int[] createRandomArray(int length) {
		int[] retVal = new int[length];
		Random rand = new Random();
		for(int i =0; i<length; i++) {
			retVal[i] = rand.nextInt(length)+1;
		}
		return retVal;
		
	}
}
