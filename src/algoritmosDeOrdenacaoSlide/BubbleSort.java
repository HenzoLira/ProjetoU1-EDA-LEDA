package algoritmosDeOrdenacaoSlide;

import util.Swap;

public class BubbleSort {
	
	public static void bubbleSort (int[] array) {
		
		int n = array.length;
		
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-i; j++) {
				if(array[j] > array[j+1]) {
					Swap.swap(array, j, j+1);
				}
			}
		}
		
	}

}
