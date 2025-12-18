package algoritmosDeBusca;

import model.Estudante;

public class LinearIterativaDuasPontas {
	
	public static int buscar(Estudante[] array, int alvo) {
		int i = 0;					// ponteiro no inicio
		int j = array.length - 1;	// ponteiro no fim
		
		while(i<=j) {				// enquanto não se cruzam

			if(array[i].getMatricula() == alvo) {	// verifica esquerda
				return i;
			}
			
			if(array[j].getMatricula() == alvo) {	// verifica direita
				return j;
			}
			
			if(array[i].getMatricula() > alvo || array[j].getMatricula() < alvo) {
				break;				// otimização para array previamente ordenado
			}
			
			i++;					// move os ponteiros em direção ao centro
			j--;
		}
		
		return -1;
	}

}
