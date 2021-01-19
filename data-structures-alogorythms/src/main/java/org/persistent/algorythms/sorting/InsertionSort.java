package org.persistent.algorythms.sorting;

import java.util.Arrays;
import java.util.Random;

import org.apache.commons.lang.ArrayUtils;

public class InsertionSort {

	private static Random random = new Random();
	private static final int NUMBER_OF_ARRAY_ELEMENTS = 100000;

	private static int getRandomNumberInRange(int min, int max) {
		return random.nextInt((max - min) + 1) + min;
	}
	
	private static int[] getRamdomElementArray()
	{
		final int[] elementArray = new int[NUMBER_OF_ARRAY_ELEMENTS];
		for (int x = 0; x < NUMBER_OF_ARRAY_ELEMENTS; x++) {
			elementArray[x] = getRandomNumberInRange(1, NUMBER_OF_ARRAY_ELEMENTS);
		}
		return elementArray;
	}
	
	private static int[] sortArrayWithInsertionSort(int[] elementArray) {
		for (int j = 1; j < elementArray.length; j++) {
			// get the element from the index
			int key = elementArray[j];
			//Define the starting position of the backward elements.
			int k = j - 1;
			//Loop through the backward element until an less than element is found
			//Shift the greater elements to the right side to make the slot for the 
			// key value ................................
			while (k >= 0 && elementArray[k] > key) {
				elementArray[k+1] = elementArray[k];
				k= k-1;
			}
			elementArray[k+1] = key;
		}
		return elementArray;
	}

	public static void main(String[] args) {		
		int[] randomArray = getRamdomElementArray();
		long startTime = System.currentTimeMillis();
		sortArrayWithInsertionSort(randomArray);
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		System.out.println("@@@ Time for the random array:"+ executionTime);
		Arrays.sort(randomArray);
		long startTime1 = System.currentTimeMillis();
		sortArrayWithInsertionSort(randomArray);
		long endTime1 = System.currentTimeMillis();
		long executionTime1 = endTime1 - startTime1;
		System.out.println("@@@ Time for the sorted array:"+ executionTime1);		
		ArrayUtils.reverse(randomArray);
		long startTime2 = System.currentTimeMillis();
		sortArrayWithInsertionSort(randomArray);
		long endTime2 = System.currentTimeMillis();
		long executionTime2 = endTime2 - startTime2;
		System.out.println("@@@ Time for reverse sorted array:"+ executionTime2);
	}

}
