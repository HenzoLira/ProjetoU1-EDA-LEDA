package algoritmosDeOrdenacaoSlide;

import model.Estudante;
import util.Swap;

public class SelectionSort {
	
	public static void selectionSort (Estudante[] array) {
		
		int n = array.length;
		
		for(int i = 0; i < n-1; i++) { 			// percorre o array para determinar a posição correta onde o próximo menor elemento deve ser inserido
			int min = i;						// inicializa o indice do menor elemento encontrado na porção não ordenada com a posição atual
			for(int j = i+1; j < n; j++) {		// percorre a parte restante do array buscando o verdadeiro menor elemento (se tiver)
				if(array[j].compareTo(array[min]) < 0) {		// compara o elemento atual (j) com o menor encontrado até então (min)
					min = j;
				}
			}
			Swap.swap(array, i, min);
		}
	}

}
