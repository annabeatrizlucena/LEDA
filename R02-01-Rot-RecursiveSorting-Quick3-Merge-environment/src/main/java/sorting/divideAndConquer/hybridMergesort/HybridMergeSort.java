package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes: - Ter
 * contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 * que essa informação possa ser capturada pelo teste. - A cada chamado do
 * método de sort(T[] array) esses contadores são resetados. E a cada chamada
 * interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 * INSERTIONSORT_APPLICATIONS são incrementados. - O InsertionSort utilizado no
 * algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort algorithm
	 * will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {
			MERGESORT_APPLICATIONS = 0;
			INSERTIONSORT_APPLICATIONS = 0;
			this.hybridMergesort(array, leftIndex, rightIndex);
		}
	}

	private void hybridMergesort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {

			int numberOfElements = ((rightIndex - leftIndex) +1);
			if(numberOfElements <= SIZE_LIMIT) {
				
				this.insertionSort(array, leftIndex, rightIndex);
				INSERTIONSORT_APPLICATIONS ++;
				
			}else {
				this.mergeSort(array, leftIndex, rightIndex);
				MERGESORT_APPLICATIONS ++;
				
			}
			
		}

	}

	private void mergeSort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {

			int middleIndex = (leftIndex + rightIndex) / 2;

			this.hybridMergesort(array, leftIndex, middleIndex);
			this.hybridMergesort(array, middleIndex + 1, rightIndex);
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

	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {
			
			for (int i = leftIndex + 1; i <= rightIndex; i++) {
				int j = i;
				while (j > leftIndex && array[j].compareTo(array[j - 1]) < 0) {
					Util.swap(array, j, j - 1);
					j--;
				}
			}
		}
	}

}
