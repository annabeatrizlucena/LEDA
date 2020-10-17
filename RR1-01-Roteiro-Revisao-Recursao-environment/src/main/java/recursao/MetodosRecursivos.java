package recursao;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array) {
		int tamanho = array.length;
		return calcularSomaArray(array, tamanho);

	}

	private int calcularSomaArray(int[] array, int tamanho) {
		if (tamanho == 0) {
			return 0;
		}
		if (tamanho == 1) {
			return array[0];
		}
		return array[tamanho - 1] + calcularSomaArray(array, tamanho - 1);
	}

	public long calcularFatorial(int n) {
		long result = n;
		if (result <= 1) {
			return 1;
		}
		return n * calcularFatorial(n - 1);
	}

	public int calcularFibonacci(int n) {
		int result = 0;
		if (n == 1 || n == 2) {
			result += 1;
		} else {
			result = calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
		}
		return result;
	}

	public int countNotNull(Object[] array) {
		int tamanho = array.length;
		return countNotNull(array, tamanho - 1);
	}

	private int countNotNull(Object[] array, int tamanho) {
		int saida = 0;
		if (tamanho < 0) {
			return 0;
		}
		if (array[tamanho] != null) {
			saida += 1;
		}

		return saida + countNotNull(array, tamanho - 1);

	}

	public long potenciaDe2(int expoente) {
		long result = 1;
		if (expoente == 0) {
		} else {
			result = 2 * potenciaDe2(expoente - 1);
		}
		return result;
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = termoInicial;
		if (n == 1) {
		} else {
			result = progressaoAritmetica(termoInicial + razao, razao, n - 1);
		}
		return result;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = termoInicial;
		if (n == 1) {
		} else {
			result = progressaoGeometrica(termoInicial * razao, razao, n - 1);
		}
		return result;
	}

}
