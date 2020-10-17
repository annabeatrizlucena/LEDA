package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {

			int middleIndex = (leftIndex + rightIndex) / 2;

			this.sort(array, leftIndex, middleIndex);
			this.sort(array, middleIndex + 1, rightIndex);
			this.merge(array, leftIndex, middleIndex, rightIndex);
		}

	}

	private void merge(T[] array, int leftIndex, int middleIndex, int rightIndex) {

		T[] help = (T[]) new Comparable[array.length];

		for (int i = leftIndex; i <= rightIndex; i++) {
			help[i] = array[i];
		}

		int firstIterator = leftIndex;
		int secondIterator = middleIndex + 1;
		int auxIterator = leftIndex;

		while (firstIterator <= middleIndex && secondIterator <= rightIndex) {
			if (help[firstIterator].compareTo(help[secondIterator]) < 0) {
				array[auxIterator] = help[firstIterator];
				firstIterator++;
			} else {
				array[auxIterator] = help[secondIterator];
				secondIterator++;
			}
			auxIterator++;

		}
		while (firstIterator <= middleIndex) {
			array[auxIterator] = help[firstIterator];
			firstIterator++;
			auxIterator++;

		}
		while (secondIterator <= rightIndex) {
			array[auxIterator] = help[secondIterator];
			secondIterator++;
			auxIterator++;

		}

	}
}
