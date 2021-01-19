package org.persistent.algorythms.searching;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LinearSearch {

	private static final int NUMBER_OF_ARRAY_ELEMENTS = 100000;

	private static Integer[] getGeneratedElementArray() {
		final Integer[] elementArray = new Integer[NUMBER_OF_ARRAY_ELEMENTS];
		for (int x = 0; x < NUMBER_OF_ARRAY_ELEMENTS; x++) {
			elementArray[x] = Integer.valueOf(x);
		}
		return elementArray;
	}

	private static Integer searchUsingLinerMethod(Integer[] arrayToeBeSearched, int value) {
		for (int j = 0; j < arrayToeBeSearched.length; j++) {
			if (arrayToeBeSearched[j] == value) {
				return value;
			}
		}
		return -1;
	}

	private static Integer searchUsingArrayList(List<Integer> arrayToeBeSearched, int value) {
		int valueIdx = arrayToeBeSearched.indexOf(value);
		if (valueIdx > 0) {
			return arrayToeBeSearched.get(valueIdx);
		}
		return -1;
	}

	public static void main(String[] args) {
		final Integer[] randomArray = getGeneratedElementArray();
		long startTime = System.currentTimeMillis();
		int searchedValue = searchUsingLinerMethod(randomArray, 95000);
		System.out.println("@@@@@ Searched value array @@@@@:" + searchedValue);
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		System.out.println("@@@ Time for the array:" + executionTime);
		List<Integer>  integerList = Arrays.asList(randomArray);
		long startTime1 = System.currentTimeMillis();
		int searchedValue1 = searchUsingArrayList(integerList, 95000);
		System.out.println("@@@@@ Searched value list @@@@@:" + searchedValue1);
		long endTime1 = System.currentTimeMillis();
		long executionTime1 = endTime1 - startTime1;
		System.out.println("@@@ Time for the list:" + executionTime1);
	}

}
