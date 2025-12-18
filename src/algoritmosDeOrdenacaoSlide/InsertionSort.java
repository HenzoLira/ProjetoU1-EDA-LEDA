package algoritmosDeOrdenacaoSlide;

import model.Estudante;

public class InsertionSort {
	
	public static void insertionSort(Estudante[] array) {
		int n = array.length;
		
		for(int j = 1; j < n; j++) {			// começa no segundo elemento e o considera a chave para inserção
			Estudante key = array[j];					// armazena o valor a ser inserido na porção ordenada.
			int i = j-1;						// o ponteiro de comparação é iniciado para j-1 (ultimo elemento da porção ordenada), a busca da posição correta da key começará aqui e seguirá para a esquerda
			
			while (i>=0 && array[i].compareTo(key) > 0) {	// i >= 0 garante que o índice não saia dos limites (não tenta acessar um índice negativo)
												// array[i] > key garante que a chave atual(key) é menor que o elemento que está sendo comparado (array[i])
												// se ambas forem verdadeiras o deslocamento ocorre
				array[i+1] = array[i];			// o elemento maior é movido uma posição para a direita, e abre um espaço na posição i
				i = i-1;						// o ponteiro i se move para a esquerda e continua a procurar elementos maiores que a key
			}
			
			array[i+1] = key;					// o while para em i, a a posição que o espaço foi liberado esta em i+1, a key é inserida neste local
		}
	}

}
