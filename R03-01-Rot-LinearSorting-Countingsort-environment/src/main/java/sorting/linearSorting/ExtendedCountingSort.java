package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(leftIndex >=0 && rightIndex < array.length && leftIndex < rightIndex && array.length > 0) {
			int maxElement = getMax(array, leftIndex, rightIndex);
			int minElement = getMin(array, leftIndex, rightIndex);
			
			int[] counter = new int[maxElement - minElement + 1];
			Integer[] auxiliary = new Integer[rightIndex - leftIndex +1];
			
			for(int i = leftIndex; i<= rightIndex; i++) {
				counter[array[i]- minElement] +=1;
			}
			
			for(int i = 1; i <= counter.length -1; i++ ) {
				counter[i] += counter[i-1];
			}

			for(int i = rightIndex; i>= leftIndex; i--) {
				auxiliary[counter[array[i] - minElement] - 1] = array[i];
				counter[array[i] - minElement] -=1;
				
			}

			for(int i= leftIndex; i<= rightIndex; i++) {
				array[i] = auxiliary[i - leftIndex];
			}
		}
		
	}

	private int getMax(Integer[] array, int leftIndex, int rightIndex) {
		int max = array[leftIndex];
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i].compareTo(max) > 0) {
				max = array[i];
			}
		}
		return max;
	}

	private int getMin(Integer[] array, int leftIndex, int rightIndex) {
		int min = array[leftIndex];
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i].compareTo(min) < 0) {
				min = array[i];
			}
		}
		return min;
	}

}
