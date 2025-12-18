package algoritmosOdenacaoOtimizados;

import java.util.Arrays;

import model.Estudante;

public class QuickSortJava {		// versão Java solicitada
	
	public static void sort(int[] array) {	// primitivos
		Arrays.sort(array);			// Java usa dual-pivot quicksort para arrays de int
	}

	public static void sort(Estudante[] array) {	// objetos
		Arrays.sort(array);			// Aqui o Java usará internamente o TimSort
	}
}
