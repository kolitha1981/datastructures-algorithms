package org.persistent.algorythms.sorting;

import java.util.Random;

public class SelectionSort {

	private static Random random = new Random();

	private static int getRandomNumberInRange(int min, int max) {
		return random.nextInt((max - min) + 1) + min;
	}

	public static void main(String[] args) {
		//Create the array ...........................
		final int[] unsortedArray = new int[10];
		//Fill array with random values ...............
		for (int k = 0; k < 10; k++) {
			unsortedArray[k] = getRandomNumberInRange(1, 10);
			System.out.println("@@@@@@@@ UnsortedArray:" + unsortedArray[k]);
		}
		//start the first loop and set the starting index...... this should
		//loop  for n number of elements
		for(int x = 0; x< unsortedArray.length ; x++){
			int minimumIndex = x;
			//Get the minimum from the remaining array ........
			//this should loop for (n-1), (n-2), (n-3)  number of elements .........
			//So the complexity of the algorithm is O(n*n) 
			for( int j = x+1 ; j < unsortedArray.length; j ++) {
				if(unsortedArray[j]  < unsortedArray[minimumIndex]) {
					minimumIndex = j;
				}				
			}
			//Swap the minimum element with the first element of the array
			int temp =  unsortedArray[minimumIndex];
			unsortedArray[minimumIndex] = unsortedArray[x];
			unsortedArray[x] = temp;
		}
		for (int k = 0; k < 10; k++) {
			System.out.println("@@@@@@@@ SortedArray:" + unsortedArray[k]);
		}
	}

}
