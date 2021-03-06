package org.persistent.algorythms.sorting;

import java.util.Arrays;
import java.util.Random;

import org.apache.commons.lang.ArrayUtils;

public class SelectionSort {

	private static Random random = new Random();
	private static final int NUMBER_OF_ARRAY_ELEMENTS = 100000;

	private static int getRandomNumberInRange(int min, int max) {
		return random.nextInt((max - min) + 1) + min;
	}

	private static int[] getRamdomElementArray() {
		final int[] elementArray = new int[NUMBER_OF_ARRAY_ELEMENTS];
		for (int x = 0; x < NUMBER_OF_ARRAY_ELEMENTS; x++) {
			elementArray[x] = getRandomNumberInRange(1, NUMBER_OF_ARRAY_ELEMENTS);
		}
		Arrays.sort(elementArray);
		return elementArray;
	}

	private static int[] sortArrayWithSelectionSort(int[] elementArray) {
		// start the first loop and set the starting index...... this should
		// loop for n number of elements
		for (int x = 0; x < elementArray.length; x++) {
			int minimumIndex = x;
			// Get the minimum from the remaining array ........
			// this should loop for (n-1), (n-2), (n-3) number of elements .........
			// So the complexity of the algorithm is O(n*n)
			for (int j = x + 1; j < elementArray.length; j++) {
				if (elementArray[j] < elementArray[minimumIndex]) {
					minimumIndex = j;
				}
			}
			// Swap the minimum element with the first element of the array
			int temp = elementArray[minimumIndex];
			elementArray[minimumIndex] = elementArray[x];
			elementArray[x] = temp;
		}
		return elementArray;
	}

	public static void main(String[] args) {
		int[] randomArray = getRamdomElementArray();
		long startTime = System.currentTimeMillis();
		sortArrayWithSelectionSort(randomArray);
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		System.out.println("@@@ Time for the random array:"+ executionTime);
		Arrays.sort(randomArray);
		long startTime1 = System.currentTimeMillis();
		sortArrayWithSelectionSort(randomArray);
		long endTime1 = System.currentTimeMillis();
		long executionTime1 = endTime1 - startTime1;
		System.out.println("@@@ Time for the sorted array:"+ executionTime1);		
		ArrayUtils.reverse(randomArray);
		long startTime2 = System.currentTimeMillis();
		sortArrayWithSelectionSort(randomArray);
		long endTime2 = System.currentTimeMillis();
		long executionTime2 = endTime2 - startTime2;
		System.out.println("@@@ Time for reverse sorted array:"+ executionTime2);
	}

}
