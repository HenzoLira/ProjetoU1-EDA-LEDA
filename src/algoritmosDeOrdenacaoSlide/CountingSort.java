package algoritmosDeOrdenacaoSlide;

public class CountingSort {
	
	public static int[] countingSort (int[] array) {
		
		int k = findMax(array);					// valor maximo do array
		int n = array.length;					// tamanho do array

		int[] arrayB = new int[n];				// elementos ordenados serão armazenados		
		int[] contagem = new int[k+1];			// contagem de frequencia, indices de 0 até k

	
		for(int j = 0; j<n; j++) {
			contagem[array[j]]++;				// pega o valor atual do array (A[j]) e usa como índice de C.
		}										// e incrementa o "contador" nesse endereço
	
		
		for(int i = 1; i <= k; i++) {			// fazendo a soma dos prefixos
			contagem[i] = contagem[i] + contagem[i-1];
		}
		
		
		for(int j = n-1; j>=0; j--) {			// iterar de trás para frente garante que mantenha a estabilidade
			
			int posicaoFinal = contagem[array[j]]; 	// consulta a posição do elemento
			
			arrayB[posicaoFinal-1] = array[j];	// insere o elemento na posicao correta
			
			contagem[array[j]]--;				// decrementa a contagem
		}
		
		return arrayB;
	
	}
	
	
	private static int findMax(int[] array) {	// encontrar o valor máximo no array de entrada
		if(array == null || array.length < 1) {
			throw new IllegalArgumentException("O array é nulo/vazio.");
		}
		
		int max = array[0];						// inicia como valor máximo o primeiro valor
		
		for (int i = 1; i < array.length; i++) {
			if(array[i] > max) {				// varre comparando o valor da posição com o max
				max = array[i];
			}
		}
		return max;
	}

}
