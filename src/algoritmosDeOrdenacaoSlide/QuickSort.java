package algoritmosDeOrdenacaoSlide;

import model.Estudante;
import util.Swap;

public class QuickSort {
	
	public static void sort(Estudante[] array) {
		quickSort(array, 0, array.length - 1);
	}
	
	private static void quickSort(Estudante[] array, int left, int right) {
		
		if (left < right) {							// caso base: se a lista sublista tem 0 ou 1 elemento
			int pivot = partition(array, left, right);	// posiciona o pivô no lugar correto e retorna seu índice
			
			quickSort(array, left, pivot-1);		// chamada para sublista da esquerda
			quickSort(array, pivot+1, right);		// chamada para sublista da direita
		}
	}
	
	private static int partition(Estudante[] array, int left, int right) {
		
		Estudante pivo = array[left];						// primeiro elemento (hoare com pivo fixo no inicio)
		int i = left + 1;							// ponteiro da esquerda
		int j = right;								// ponteiro da direita

		while(i<=j) {								// continua enquanto não se cruzarem
			while(i <= right && array[i].compareTo(pivo) <= 0) {	// laço para avançar i, enquanto [i] <= pivo e nao ultrapassar o limite
				i++;
			}
			while(array[j].compareTo(pivo) > 0 && j > left) {	// laço para recuar j, enquanto [j] > pivo e nal ultrapassar o pivo
				j--;
			}
			
			if(i<j) {								// se i e j ainda não se cruzaram, troca os elementos fora de ordem
				Swap.swap(array, i, j);
			}			
		}
		
		Swap.swap(array, left, j);					// troca o pivô com o elemento na posição final da partição j
		return j;									// posição do pivô
	}

}
