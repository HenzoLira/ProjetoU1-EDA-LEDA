package algoritmosDeBusca;

import model.Estudante;

public class BinariaRecursiva {
	
	public static int buscar(Estudante[] array, int alvo, int esq, int dir) {
		
		if(esq>dir) {
			return -1;	// caso base, intervalo de busca esgotado
		}
		
		int meio = esq + (dir - esq)/2;
		
		if(array[meio].getMatricula() == alvo) {
			return meio;	// caso 1, localizado
		}
		
		if(array[meio].getMatricula() < alvo) { // se estiver a direita
			return buscar(array, alvo, meio+1, dir);
		} else {				// se estiver a esquerda
			return buscar(array, alvo, esq, meio-1);
		}
	}

}
