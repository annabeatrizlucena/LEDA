package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {

			int pivotIndex = this.partition(array, leftIndex, rightIndex);

			this.sort(array, leftIndex, pivotIndex - 1);
			this.sort(array, pivotIndex + 1, rightIndex);
		}
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		int pivotIndex = leftIndex;
		T pivot = array[leftIndex];

		for (int i = pivotIndex + 1; i <= rightIndex; i++) {
			if (pivot.compareTo(array[i]) > 0) {
				pivotIndex++;
				Util.swap(array, pivotIndex, i);

			}
		}
		Util.swap(array, leftIndex, pivotIndex);

		return pivotIndex;
	}
}
