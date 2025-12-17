package algoritmosOdenacaoOtimizados;

import util.Swap;

public class BubbleSortOtimizado {
	
public static void bubbleSortOtimizado (int[] array) {
		
		int n = array.length;
		
		
		for (int i = 0; i < n-1; i++) {			// controla numero de passadas
			
			boolean trocou = false;				// inicia como falso, para verificar se haverá troca
			
			for (int j = 0; j < n-i; j++) {		// laço interno faz comparações e trocas
				if(array[j] > array[j+1]) {
					Swap.swap(array, j, j+1);
					trocou = true;				// marca de ocorreu troca, o array ainda não está ordenado
				}
			}
			
			if (!trocou) {				// otimização (para antes)
				break;
			}
		}
		
	}

}
