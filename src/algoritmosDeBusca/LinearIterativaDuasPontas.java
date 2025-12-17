package algoritmosDeBusca;

public class LinearIterativaDuasPontas {
	
	public static int buscar(int[] array, int alvo) {
		int i = 0;					// ponteiro no inicio
		int j = array.length - 1;	// ponteiro no fim
		
		while(i<=j) {				// enquanto não se cruzam

			if(array[i] == alvo) {	// verifica esquerda
				return i;
			}
			
			if(array[j] == alvo) {	// verifica direita
				return j;
			}
			
			if(array[i] > alvo || array[j] < alvo) {
				break;				// otimização para array previamente ordenado
			}
			
			i++;					// move os ponteiros em direção ao centro
			j--;
		}
		
		return -1;
	}

}
