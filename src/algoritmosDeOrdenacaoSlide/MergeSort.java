package algoritmosDeOrdenacaoSlide;

public class MergeSort {

	public static void sort(int[] array) {
		int n = array.length;
		
		if(array == null || n<2) {
			return;
		} else {
			mergeSort(array, 0, n-1); 	// chamada inicial para ordenar de 0 até o último índice
		}
	}
	
	
	private static void mergeSort(int[] array, int left, int right) {
		
		if (left >= right) {						// caso base, se a sub-lista tem 0 ou 1 elemento ela está ordenada
			return;
		}
		
		int mid = (left + (right - left))/2;		// calcula o ponto médio
		
		mergeSort(array, left, mid);				// ordena a metade da esquerda (left até mid)
		mergeSort(array, mid+1, right);				// ordena a metade da direita
		
		merge(array, left, mid, right);									// junta as duas metades ordenadas (merge_the_two_sorted_lists)
	}
	
	
	private static void merge(int[] array, int left, int mid, int right) {
		
		int size = right - left + 1;				// tamanho do auxiliar, o numero total de elementos entre left e right, incluindo eles
		int[] aux = new int[size];
		
		for(int k = 0; k < size; k++) { 			// k é o índece de destino no aux[] (0,1,...)
			aux[k] = array[left + k];				// left+k é o índice de origem no array original
		}
		
		int i = 0;									// ponteiro para início da sublista esquerda no auxiliar		
		int j = mid - left + 1;						// ponteiro para inicio da sublista direita no auxiliar (começa após o fim da esquerda)
		int k = left;								// ponteiro de escrita no array original
		
		while(i <= mid - left && j < size) {		// continua enuanto houver elementos nas duas sublistas do auxiliar
			if (aux[i] <= aux[j]) {
				array[k] = aux[i];					// quando o da esquerda é menor/igual, copia para o array original
				i++;								// avança ponteiro da esquerda
			} else {
				array[k] = aux[j];					// se o da direita é menor, copia para o original
				j++;
			}
			k++;									// avança ponteirro de escrita (original)
		}
		
		while(i <= mid-left) {
			array[k] = aux[i];						// se a sublista direita acabar primeiro copia o que sobrou da esquerda
			k++;
			i++;									// não precisa de um laço para a direita, pois os elementos restantes (caso tenha)
		}											// já estão no original (o que está em aux é identico ao original)
		
		
	}
	
}
