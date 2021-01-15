package org.persistent.algorythms.sorting;

import java.util.Arrays;
import java.util.Random;

import org.apache.commons.lang.ArrayUtils;

public class InsertionSortwithRecursion {

	private static Random random = new Random();
	private static final int NUMBER_OF_ARRAY_ELEMENTS = 10000;

	private static int getRandomNumberInRange(int min, int max) {
		return random.nextInt((max - min) + 1) + min;
	}

	private static int[] getRamdomElementArray() {
		final int[] elementArray = new int[NUMBER_OF_ARRAY_ELEMENTS];
		for (int x = 0; x < NUMBER_OF_ARRAY_ELEMENTS; x++) {
			elementArray[x] = getRandomNumberInRange(1, NUMBER_OF_ARRAY_ELEMENTS);
		}
		return elementArray;
	}

	private static void sortArrayUsingInsertionSortWithRecursion(int[] elementArray, int elementSize) {
		// Base case
		if (elementSize <= 1) {
			return;
		}
		// Sort first n-1 elements
		sortArrayUsingInsertionSortWithRecursion(elementArray, elementSize - 1);
		// Insert last element at its correct position in sorted array.
		int last = elementArray[elementSize - 1];
		int j = elementSize - 2;
		// Move elements of arr[0..i-1], that are greater than key, to one position
		// ahead
		// of their current position
		while (j >= 0 && elementArray[j] > last) {
			elementArray[j + 1] = elementArray[j];
			j--;
		}
		elementArray[j + 1] = last;
		
	}

	public static void main(String[] args) {
		int[] randomArray = getRamdomElementArray();
		long startTime = System.currentTimeMillis();
		sortArrayUsingInsertionSortWithRecursion(randomArray, randomArray.length);
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		System.out.println("@@@@@ Sorted array for the random array:" + ArrayUtils.toString(randomArray));
		System.out.println("@@@ Time for the random array:" + executionTime);
		Arrays.sort(randomArray);
		long startTime1 = System.currentTimeMillis();
		sortArrayUsingInsertionSortWithRecursion(randomArray, randomArray.length);
		long endTime1 = System.currentTimeMillis();
		long executionTime1 = endTime1 - startTime1;
		System.out.println("@@@@@ Sorted array for the sorted array:" + ArrayUtils.toString(randomArray));
		System.out.println("@@@ Time for the sorted array:" + executionTime1);
		ArrayUtils.reverse(randomArray);
		long startTime2 = System.currentTimeMillis();
		sortArrayUsingInsertionSortWithRecursion(randomArray, randomArray.length);
		long endTime2 = System.currentTimeMillis();
		long executionTime2 = endTime2 - startTime2;
		System.out.println("@@@@@ Sorted array for reverse sorted array:" + ArrayUtils.toString(randomArray));
		System.out.println("@@@ Time for reverse sorted array:" + executionTime2);
	}

}
