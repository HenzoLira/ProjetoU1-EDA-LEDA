package util;

import model.Estudante;

public class Swap {
	
	// Troca os elementos nas posições i e j de um array de inteiros.
	
	public static void swap(Estudante[] array, int i, int j) {
		Estudante temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
