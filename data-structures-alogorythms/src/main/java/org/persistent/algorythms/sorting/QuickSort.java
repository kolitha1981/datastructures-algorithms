package org.persistent.algorythms.sorting;

import java.util.Arrays;
import java.util.Random;

import org.apache.commons.lang.ArrayUtils;

public class QuickSort {
	
	private static Random random = new Random();
	private static final int NUMBER_OF_ARRAY_ELEMENTS = 1000;

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
	
	private static int partition(int unsortedArray[], int low, int high) 
    { 
		//Select the pivot from upper bound of the array.
        int pivot = unsortedArray[high];
        // the index of the smaller element 
        int i = (low-1);
        for (int j= low; j< high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (unsortedArray[j] < pivot) 
            { 
                i++;  
                // swap partionedArray[i] and partionedArray[j] 
                int temp = unsortedArray[i]; 
                unsortedArray[i] = unsortedArray[j]; 
                unsortedArray[j] = temp; 
            } 
        }  
        // swap partionedArray[i+1] and arr[high] (or pivot) 
        int temp = unsortedArray[i+1]; 
        unsortedArray[i+1] = unsortedArray[high]; 
        unsortedArray[high] = temp;   
        return i+1; 
    } 

    private static void sortArrayWithQuickSort(int unsortedArray[], int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, unsortedArray[pi] is now at right place */
            int pi = partition(unsortedArray, low, high);  
            // Recursively sort elements before partition and after partition 
            sortArrayWithQuickSort(unsortedArray, low, pi-1); 
            sortArrayWithQuickSort(unsortedArray, pi+1, high); 
        } 
    }
    
    public static void main(String[] args) {
    	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		int[] randomArray = getRamdomElementArray();
		final String randomArrayString = ArrayUtils.toString(randomArray);
		System.out.println("@@@@@ Random array :" + randomArrayString);
		long startTime = System.currentTimeMillis();
		sortArrayWithQuickSort(randomArray, 0, (randomArray.length -1));
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		System.out.println("@@@ Time for the random array:"+ executionTime);
		System.out.println("@@@@@ Sorted random array :"+ ArrayUtils.toString(randomArray));
		Arrays.sort(randomArray);
		long startTime1 = System.currentTimeMillis();
		sortArrayWithQuickSort(randomArray, 0, (randomArray.length -1));
		long endTime1 = System.currentTimeMillis();
		long executionTime1 = endTime1 - startTime1;
		System.out.println("@@@ Time for the sorted array:"+ executionTime1);
		System.out.println("@@@@@ Sorted array :"+ ArrayUtils.toString(randomArray));
		ArrayUtils.reverse(randomArray);
		long startTime2 = System.currentTimeMillis();
		sortArrayWithQuickSort(randomArray, 0, (randomArray.length -1));
		long endTime2 = System.currentTimeMillis();
		long executionTime2 = endTime2 - startTime2;
		System.out.println("@@@ Time for reverse sorted array:"+ executionTime2);
		System.out.println("@@@@@ Reverse sorted array :"+ ArrayUtils.toString(randomArray));
	}

}
