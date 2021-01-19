package org.persistent.algorythms.searching;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

	private static Random random = new Random();
	private static final int NUMBER_OF_ARRAY_ELEMENTS = 10000000;

	private static int[] getRamdomElementArray() {
		final int[] elementArray = new int[NUMBER_OF_ARRAY_ELEMENTS];
		for (int x = 0; x < NUMBER_OF_ARRAY_ELEMENTS; x++) {
			elementArray[x] = x;
		}
		return elementArray;
	}

	// Returns index of x if it is present in arr[l..// r], else return -1
	private static int searchValueUsingBinarySearch(int[] arrayToBeSearched, int lowerIndex, int upperIndex, int valueToBeSeached) {
		if (upperIndex >= lowerIndex) {
			int middleIndex = lowerIndex + (upperIndex - lowerIndex) / 2;
			// If the element is present at the middle itself
			if (arrayToBeSearched[middleIndex] == valueToBeSeached)
				return middleIndex;
			// If element is smaller than mid, then it can only be present in left subarray
			if (arrayToBeSearched[middleIndex] > valueToBeSeached)
				return searchValueUsingBinarySearch(arrayToBeSearched, lowerIndex, middleIndex - 1, valueToBeSeached);
			// Else the element can only be present in right subarray
			return searchValueUsingBinarySearch(arrayToBeSearched, middleIndex + 1, upperIndex, valueToBeSeached);
		}
		// We reach here when element is not present in array
		return -1;
	}
	
	public static void main(String[] args) {
		final int[] randomArray = getRamdomElementArray();
		Arrays.sort(randomArray);
		long startTime = System.currentTimeMillis();
		int searchedValue = searchValueUsingBinarySearch(randomArray, 0, randomArray.length -1, 9500000);
		System.out.println("@@@@@ Searched value  @@@@@:" + searchedValue);
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		System.out.println("@@@ Time for binary search (1):" + executionTime);
		long startTime1 = System.currentTimeMillis();
		int searchedValue1 = Arrays.binarySearch(randomArray, 9500000);
		System.out.println("@@@@@ Searched value 1 @@@@@:" + searchedValue1);
		long endTime1 = System.currentTimeMillis();
		long executionTime1 = endTime1 - startTime1;
		System.out.println("@@@ Time for binary search (2):" + executionTime1);
	}

}
