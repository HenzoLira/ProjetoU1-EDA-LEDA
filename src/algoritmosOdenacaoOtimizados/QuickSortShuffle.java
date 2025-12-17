package algoritmosOdenacaoOtimizados;

import java.util.Random;

import util.Swap;

public class QuickSortShuffle { // embaralha o array antes de iniciar

	public static void sort(int[] array) {

		shuffle(array);							// aplica o shuffle no array
		
		quickSort(array, 0, array.length-1);	// chama o quick recursivo
		
	}

	private static void shuffle(int[] array) {
		
		Random random = new Random();
		
		for (int i = array.length - 1; i > 0; i--) {
			int j = random.nextInt(i + 1);		// escolhe um indice aleatorio entre 0 e i
			Swap.swap(array, i, j);				// troca o elemento atual com o aleatório
		}
	}

	private static void quickSort(int[] array, int left, int right) {

		if (left < right) {						// caso base: se a lista sublista tem 0 ou 1 elemento
			int pivot = partition(array, left, right); // posiciona o pivô no lugar correto e retorna seu índice

			quickSort(array, left, pivot - 1); // chamada para sublista da esquerda
			quickSort(array, pivot + 1, right); // chamada para sublista da direita
		}
	}

	private static int partition(int[] array, int left, int right) {

		int pivo = array[left]; 				// primeiro elemento (hoare com pivo fixo no inicio)
		int i = left + 1; 						// ponteiro da esquerda
		int j = right; 							// ponteiro da direita

		while (i <= j) { 						// continua enquanto não se cruzarem
			while (i <= right && array[i] <= pivo) { // laço para avançar i, enquanto [i] <= pivo e nao ultrapassar o
												// limite
				i++;
			}
			while (array[j] > pivo && j > left) { // laço para recuar j, enquanto [j] > pivo e nal ultrapassar o pivo
				j--;
			}

			if (i < j) { 						// se i e j ainda não se cruzaram, troca os elementos fora de ordem
				Swap.swap(array, i, j);
			}
		}

		Swap.swap(array, left, j); // troca o pivô com o elemento na posição final da partição j
		return j; // posição do pivô
	}
}
