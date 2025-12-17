package util;

public class Swap {
	
	// Troca os elementos nas posições i e j de um array de inteiros.
	
	public static void swap(int [] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
