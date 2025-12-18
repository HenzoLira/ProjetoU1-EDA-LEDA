package algoritmosDeOrdenacaoSlide;

import model.Estudante;
import util.Swap;

public class BubbleSort {
	
	public static void bubbleSort (Estudante[] array) {
		
		int n = array.length;
		
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-i-1; j++) {				// n-i-1 para o j+1 não acesse fora
				if(array[j].compareTo(array[j+1]) > 0) {
					Swap.swap(array, j, j+1);
				}
			}
		}
		
	}

}
