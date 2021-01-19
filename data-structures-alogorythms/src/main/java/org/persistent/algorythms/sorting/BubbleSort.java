package org.persistent.algorythms.sorting;

import java.util.Arrays;
import java.util.Random;

import org.apache.commons.lang.ArrayUtils;

public class BubbleSort {

	private static Random random = new Random();
	private static final int NUMBER_OF_ARRAY_ELEMENTS = 1000;

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

	private static void sortArrayUsingBubbleSort(int unsortedArray[]) {
		int n = unsortedArray.length;
		// The outer loop selects an element and loops the element through the array.
		for (int i = 0; i < n - 1; i++) {
			// The inner loop will compare each element from the outer loop with the
			// inner loop elements if finds a less element swaps elements..........
			// Define a boolean value to check if a swap has ben done in the inner loop
			boolean elementsSwapped = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (unsortedArray[j] > unsortedArray[j + 1]) {
					// swap unsortedArray[j+1] and unsortedArray[j]
					int temp = unsortedArray[j];
					unsortedArray[j] = unsortedArray[j + 1];
					unsortedArray[j + 1] = temp;
					elementsSwapped = true;
				}
			}
			if (!elementsSwapped) {
				// if any elements are not being swapped that array is sorted
				// So the inner loop can be terminated .
				break;
			}
		}
	}

	private static void sortArrayUsingBubbleSortWithRecursion(int unsortedArray[], int n) {
		// Base case
		if (n == 1)
			return;
		// One pass of bubble sort. After this pass, the largest element is moved (or
		// bubbled) to end.
		for (int i = 0; i < n - 1; i++) {
			if (unsortedArray[i] > unsortedArray[i + 1]) {
				// swap unsortedArray[j+1] and unsortedArray[j]
				int temp = unsortedArray[i];
				unsortedArray[i] = unsortedArray[i + 1];
				unsortedArray[1 + 1] = temp;
			}
		}
		// Largest element is fixed recur for remaining array
		sortArrayUsingBubbleSortWithRecursion(unsortedArray, n - 1);
	}

	public static void main(String[] args) {
		System.out.println("@@@@@@@@ Started sorting with bubble sort @@@@@@@@@@");
		int[] randomArray = getRamdomElementArray();
		long startTime = System.currentTimeMillis();
		sortArrayUsingBubbleSort(randomArray);
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		System.out.println("@@@ Time for the random array:" + executionTime);
		Arrays.sort(randomArray);
		long startTime1 = System.currentTimeMillis();
		sortArrayUsingBubbleSort(randomArray);
		long endTime1 = System.currentTimeMillis();
		long executionTime1 = endTime1 - startTime1;
		System.out.println("@@@ Time for the sorted array:" + executionTime1);
		ArrayUtils.reverse(randomArray);
		long startTime2 = System.currentTimeMillis();
		sortArrayUsingBubbleSort(randomArray);
		long endTime2 = System.currentTimeMillis();
		long executionTime2 = endTime2 - startTime2;
		System.out.println("@@@ Time for reverse sorted array:" + executionTime2);
		System.out.println("@@@@@@@@ Finished sorting with bubble sort @@@@@@@@@@");
		
		System.out.println("@@@@@@@@ Started sorting with bubble sort with recursion @@@@@@@@@@");
		int[] randomArray1 = getRamdomElementArray();
		long startTime3 = System.currentTimeMillis();
		sortArrayUsingBubbleSortWithRecursion(randomArray1, randomArray1.length);
		long endTime3 = System.currentTimeMillis();
		long executionTime3 = endTime3 - startTime3;
		System.out.println("@@@ Time for the random array wth recursion:" + executionTime3);
		Arrays.sort(randomArray1);
		long startTime4 = System.currentTimeMillis();
		sortArrayUsingBubbleSortWithRecursion(randomArray1, randomArray1.length);
		long endTime4 = System.currentTimeMillis();
		long executionTime4 = endTime4 - startTime4;
		System.out.println("@@@ Time for the sorted array wth recursion:" + executionTime4);
		ArrayUtils.reverse(randomArray1);
		long startTime5 = System.currentTimeMillis();
		sortArrayUsingBubbleSort(randomArray);
		long endTime5 = System.currentTimeMillis();
		long executionTime5 = endTime5 - startTime5;
		System.out.println("@@@ Time for reverse sorted array wth recursion:" + executionTime5);
		System.out.println("@@@@@@@@ Finished sorting with bubble sort with recursion @@@@@@@@@@");
	}

}
