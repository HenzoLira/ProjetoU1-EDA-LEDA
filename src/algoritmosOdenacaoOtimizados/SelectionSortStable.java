package algoritmosOdenacaoOtimizados;

import model.Estudante;

public class SelectionSortStable {			// sem swap
	
	public static void selectionSortStable(Estudante[] array) {
		
		int n = array.length;
		
		for(int i = 0; i < n-1; i++) {
			
			int min_idx = i;
			for(int j = i+1; j <n; j++) {
				if(array[j].compareTo(array[min_idx]) < 0) {
					min_idx = j;
				}
			}
			
			if(min_idx != i) {				// se o menor elemento encontrado não estiver na posição correta
				
				Estudante key = array[min_idx];	// salvar o valor do menor elemento (key)

				for(int k = min_idx; k > i; k--) {	// loop de min_idx até i (de tras para frente)
					array[k] = array[k-1];	// move todos os elementos entre min e i uma posição para a direita
				}
				
				array[i] = key;				// coloca o elemento na posição i, que agora está livre
			}
			
			// se min_idx == i, o elemento já está na posição correta
		}
	}

}
