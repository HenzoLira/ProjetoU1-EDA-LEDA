package algoritmosDeOrdenacaoSlide;

import model.Estudante;

public class CountingSort {
	
	public static void countingSort (Estudante[] array) {
		
		int k = findMax(array);					// valor maximo do array
		int n = array.length;					// tamanho do array

		Estudante[] arrayB = new Estudante[n];				// elementos ordenados serão armazenados		
		int[] contagem = new int[k+1];			// contagem de frequencia, indices de 0 até k

	
		for(int j = 0; j<n; j++) {
			contagem[array[j].getNota()]++;				// pega o valor atual do array (A[j]) e usa como índice de C.
		}										// e incrementa o "contador" nesse endereço
	
		
		for(int i = 1; i <= k; i++) {			// fazendo a soma dos prefixos
			contagem[i] = contagem[i] + contagem[i-1];
		}
		
		
		for(int j = n-1; j>=0; j--) {			// iterar de trás para frente garante que mantenha a estabilidade
			
			int nota = array[j].getNota();
			int posicaoFinal = contagem[nota]; 	// consulta a posição do elemento
			
			arrayB[posicaoFinal-1] = array[j];	// insere o elemento na posicao correta
			
			contagem[nota]--;				// decrementa a contagem
		}
		
		
		for(int i = 0; i<n; i++) {			// copia o resultado de volta para original (tava retornando outro array, mas deixei void para modificar o original)
			array[i] = arrayB[i];
		}
	
	}
	
	
	private static int findMax(Estudante[] array) {	// encontrar o valor máximo no array de entrada
		if(array == null || array.length < 1) {
			throw new IllegalArgumentException("O array é nulo/vazio.");
		}
		
		int max = array[0].getNota();						// inicia como valor máximo o primeiro valor
		
		for (int i = 1; i < array.length; i++) {
			if(array[i].getNota() > max) {				// varre comparando o valor da posição com o max
				max = array[i].getNota();
			}
		}
		return max;
	}

}
