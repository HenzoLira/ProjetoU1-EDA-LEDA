package algoritmosDeBusca;

import model.Estudante;

public class BinariaInterativa {
	
	public static int buscar(Estudante[] array, int alvo) {
		
		int esq = 0;
		int dir = array.length-1;
		
		while(esq <= dir) {
			int meio = esq + (dir-esq) / 2;	// calcula o meio de maneira que evite overflow

			if(array[meio].getMatricula() == alvo) {
				return meio;				// encontrou
			}
			
			if(array[meio].getMatricula() < alvo) {
				esq = meio + 1; 			// alvo está na metade direita
			} else {
				dir = meio - 1;				// alvo está na metade esquerda
			}					
		}
		return -1;
	}

}
