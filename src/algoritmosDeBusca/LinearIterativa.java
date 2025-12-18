package algoritmosDeBusca;

import model.Estudante;

public class LinearIterativa {
	
	public static int buscaLinearIterativa(Estudante[] array, int alvo) {
		
		for(int i = 0; i < array.length; i++) { // Percorre o array do índice 0 até o final
			
			if(array[i].getMatricula() == alvo) {	// se encontrar o valor, retorna o índice
				return i;
			}
			
			if(array[i].getMatricula() > alvo) {
				break;						// considerando que o vetor está previamente ordenado (de acordo com o roteiro)
			}
		}
		
		return -1; 							// se o laço encerrar sem encontrar nada
	}

}
