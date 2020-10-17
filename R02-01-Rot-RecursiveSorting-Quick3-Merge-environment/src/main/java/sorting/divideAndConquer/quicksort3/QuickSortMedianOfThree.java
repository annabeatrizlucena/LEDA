package sorting.divideAndConquer.quicksort3;


import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {
			int pivotIndex = this.partition(array, leftIndex, rightIndex);
			this.sort(array, leftIndex, pivotIndex -1);
			this.sort(array, pivotIndex+1, rightIndex);	
		}
	}
	
	private int partition(T[] array, int leftIndex, int rightIndex) {
		int middleIndex = (leftIndex + rightIndex) / 2;
		medianOfThree(array, leftIndex, middleIndex, rightIndex);
		
		T pivot = array[middleIndex];
		Util.swap(array, middleIndex, rightIndex -1);
		int pivotIndex = rightIndex -1;
		
		for(int i = pivotIndex -1; i > leftIndex ; i--) {
			if(pivot.compareTo(array[i]) < 0) {
				pivotIndex --;
				Util.swap(array, pivotIndex, i);
			}
		}
		Util.swap(array, rightIndex-1, pivotIndex);
		return pivotIndex;
		
	}
	
	private void medianOfThree(T[] array, int leftIndex,int middleIndex, int rightIndex) {
		if(array[leftIndex].compareTo(array[middleIndex]) > 0) {
			Util.swap(array, leftIndex, middleIndex);
		}
		if(array[leftIndex].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, leftIndex, rightIndex);
		}
		if(array[middleIndex].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, middleIndex, rightIndex);
		}
	}

}