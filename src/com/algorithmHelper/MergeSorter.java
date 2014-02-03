/**
 * 
 */
package com.algorithmHelper;

/**
 * @author Kaibo
 * 
 */
public class MergeSorter {

	void mergeSort(int[] array, int low, int high) {
		if (low < high) {
			int middle = (high + low) / 2;
			mergeSort(array, low, middle);
			mergeSort(array, middle + 1, high);
			merge(array, low, middle, high);
		}
	}

	/**
	 * @param array
	 * @param low
	 * @param middle
	 * @param high
	 */
	private void merge(int[] array, int low, int middle, int high) {
		int[] helper = new int[array.length];

		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}

		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;

		while (helperLeft <= middle && helperRight <= high) {
			if (helper[helperLeft] < helper[helperRight]) {
				array[current] = helper[helperLeft];
				helperLeft++;
			}

			else {
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
			printArray(array);
		}
		int remaining = middle - helperLeft;
		for (int i = 0; i <= remaining; i++) {
			array[current + i] = helper[helperLeft + i];
		}
	}

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.printf("%d\t", array[i]);
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[] { 2, 5, 6, 1, 3, 4 };
		(new MergeSorter()).mergeSort(array, 0, array.length - 1);
		printArray(array);

	}
}
