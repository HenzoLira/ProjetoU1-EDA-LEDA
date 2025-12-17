package algoritmosDeBusca;

public class BinariaRecursiva {
	
	public static int buscar(int[] array, int alvo, int esq, int dir) {
		
		if(esq>dir) {
			return -1;	// caso base, intervalo de busca esgotado
		}
		
		int meio = (esq + (dir - esq))/2;
		
		if(array[meio] == alvo) {
			return meio;	// caso 1, localizado
		}
		
		if(array[meio] < alvo) { // se estiver a direita
			return buscar(array, alvo, meio+1, dir);
		} else {				// se estiver a esquerda
			return buscar(array, alvo, esq, meio-1);
		}
	}

}
