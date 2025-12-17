package algoritmosDeBusca;

public class LinearRecursiva {
	
	public static int buscar(int[] array, int alvo, int i) {
		
		if(i >= array.length || array[i] > alvo) {
			return -1;		// caso base 1, considerando array previamente ordenado
		}					// se o índice ultrapassar o tamanho ou o valor atual for maior que o alvo
		
		if(array[i] == alvo) {
			return i;		// caso base 2: se encontrar o valor
		}
		
		return buscar(array, alvo, i+1); // recursivo, tenta buscar no próximo indice i
		
	}

}
