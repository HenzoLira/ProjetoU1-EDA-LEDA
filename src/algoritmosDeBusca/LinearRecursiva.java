package algoritmosDeBusca;

import model.Estudante;

public class LinearRecursiva {
	
	public static int buscar(Estudante[] array, int alvo) {
		return buscarR(array, alvo, 0);		// chama o metodo real
	}
	
	public static int buscarR(Estudante[] array, int alvo, int i) {
		
		if(i >= array.length || array[i].getMatricula() > alvo) {
			return -1;		// caso base 1, considerando array previamente ordenado
		}					// se o índice ultrapassar o tamanho ou o valor atual for maior que o alvo
		
		if(array[i].getMatricula() == alvo) {
			return i;		// caso base 2: se encontrar o valor
		}
		
		return buscarR(array, alvo, i+1); // recursivo, tenta buscar no próximo indice i
		
	}

}
