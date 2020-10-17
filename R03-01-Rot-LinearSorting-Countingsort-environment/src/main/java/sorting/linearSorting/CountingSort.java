package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Voce pode assumir que o maior inteiro armazenado não chega a 100.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(leftIndex >=0 && rightIndex < array.length && leftIndex < rightIndex && array.length > 0) {
			
			int maxElement = getMax(array, leftIndex, rightIndex);
			
				
				int[] counter = new int[maxElement + 1] ;
				Integer[] auxiliary = new Integer[rightIndex - leftIndex +1];
				
				
				for (int i = leftIndex; i <= rightIndex; i++) {
					counter[array[i]] +=1;
					
				}
				
				for(int i = leftIndex +1; i < counter.length; i++ ) {
					counter[i] += counter[i -1];
				}
				
				for(int i = rightIndex; i>= leftIndex; i--) {
					auxiliary[counter[array[i]] -1] = array[i];
					counter[array[i]] -=1;
				}
				
				for(int i = leftIndex; i<= rightIndex; i++) {
					array[i] = auxiliary[i - leftIndex];
				}
			}
		}

	private int getMax(Integer[] array, int leftIndex, int rightIndex) {
		int max = array[leftIndex];
		for(int i = leftIndex +1; i<= rightIndex; i++) {
			if(array[i].compareTo(max) > 0) {
				max = array[i];
			}
		}
		return max;
	}

}
