package org.persistent.algorythms.sorting;

import java.util.Arrays;
import java.util.Random;

import org.apache.commons.lang.ArrayUtils;

public class MergeSort {
	
	private static Random random = new Random();
	private static final int NUMBER_OF_ARRAY_ELEMENTS = 100;

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

	private static void merge(int arr[], int leftIndex, int middleIndex, int rightIndex) {
		// Find sizes of two sub arrays to be merged ....
		int leftArraySize = middleIndex - leftIndex + 1;
		int rightArraySize = rightIndex - middleIndex;
		/* Create temp arrays */
		int leftArray[] = new int[leftArraySize];
		int rightArray[] = new int[rightArraySize];
		/* Copy data to temp arrays */
		for (int i = 0; i < leftArraySize; ++i) {
			leftArray[i] = arr[leftIndex + i];
		}
		for (int j = 0; j < rightArraySize; ++j) {
			rightArray[j] = arr[middleIndex + 1 + j];
		}
		/* Merge the temp arrays */
		// Initial indexes of first and second subarrays
		int i = 0, j = 0;
		// Initial index of merged subarry array
		int k = leftIndex;
		while (i < leftArraySize && j < rightArraySize) {
			if (leftArray[i] <= rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}
		/* Copy remaining elements of L[] if any */
		while (i < leftArraySize) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}
		/* Copy remaining elements of R[] if any */
		while (j < rightArraySize) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
	}
	
	// Main function that sorts arr[l..r] using merge()
    private static void sortArraywithMergeSort(int unsortedArray[], int leftBoundIndex, int rightBoundIndex)
    {
        if (leftBoundIndex < rightBoundIndex) {
            // Find the middle point
            int middleValue = (leftBoundIndex + rightBoundIndex) / 2; 
            // Sort first and second halves
            sortArraywithMergeSort(unsortedArray, leftBoundIndex, middleValue);
            sortArraywithMergeSort(unsortedArray, middleValue + 1, rightBoundIndex);
             // Merge the sorted halves
            merge(unsortedArray, leftBoundIndex, middleValue, rightBoundIndex);
        }
    }
    
    public static void main(String[] args) {
    	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		int[] randomArray = getRamdomElementArray();
		final String randomArrayString = ArrayUtils.toString(randomArray);
		System.out.println("@@@@@ Random array :" + randomArrayString);
		long startTime = System.currentTimeMillis();
		sortArraywithMergeSort(randomArray, 0, (randomArray.length -1));
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		System.out.println("@@@ Time for the random array:"+ executionTime);
		System.out.println("@@@@@ Sorted random array :"+ ArrayUtils.toString(randomArray));
		Arrays.sort(randomArray);
		long startTime1 = System.currentTimeMillis();
		sortArraywithMergeSort(randomArray, 0, (randomArray.length -1));
		long endTime1 = System.currentTimeMillis();
		long executionTime1 = endTime1 - startTime1;
		System.out.println("@@@ Time for the sorted array:"+ executionTime1);
		System.out.println("@@@@@ Sorted array :"+ ArrayUtils.toString(randomArray));
		ArrayUtils.reverse(randomArray);
		long startTime2 = System.currentTimeMillis();
		sortArraywithMergeSort(randomArray, 0, (randomArray.length -1));
		long endTime2 = System.currentTimeMillis();
		long executionTime2 = endTime2 - startTime2;
		System.out.println("@@@ Time for reverse sorted array:"+ executionTime2);
		System.out.println("@@@@@ Reverse sorted array :"+ ArrayUtils.toString(randomArray));
	}

}
