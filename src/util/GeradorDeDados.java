package util;

import java.util.Random;

import model.Estudante;

public class GeradorDeDados {
	
	private static final String[] nomes = {"Henzo", "Ana", "Bruno", "Carlos", "Danilo", "Eduardo", "Livia", "Helena"};
	private static final Random random = new Random();
	
	
	public static Estudante[] gerarArrayAleatorio(int tamanho) {
		
		Estudante[] array = new Estudante[tamanho];
		
		for (int i = 0; i < tamanho; i++) {
			int matricula = i+1; 			// matricula recebe o valor de i
			int nota = random.nextInt(11);	// notas de 0 a 10 (de 0 até um a menos que o limite informado - [0,11) )
			String nome = nomes[random.nextInt(nomes.length)] + " " + (i+1); // gera nomes com sobrenomes (i+1) para garantir objetos distintos
		
			array[i] = new Estudante(matricula, nome, nota);	// adiciona um objeto(estudante)
		}
		
		embaralhar(array);				// por opção, para garantir não vai haver ordem
		return array;					// knuth shuffle (embaralhamento honesto)
	}
	
	
	public static Estudante[] gerarArrayOrdenado(int tamanho) {
		Estudante[] array = gerarArrayAleatorio(tamanho); 	// aproveitando o aleatorio
		
		java.util.Arrays.sort(array); 		// sendo usado apenas para preparar esse teste :D
		return array;
	}
	
	
	public static Estudante[] gerarArrayInverso(int tamanho) {
		
		Estudante[] array = gerarArrayOrdenado(tamanho);	// aproveitando o ordenado
		
		for(int i=0; i < array.length/2; i++) {				// inverte o array ordenado
			Estudante temp = array[i];						// o laço percorre apenas a metade porque a cada iteração, é trocado 2 elementos de uma vez
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;
		}
		
		return array;
	}
	
	private static void embaralhar(Estudante[] array) {
		
		for (int i = array.length - 1; i>0; i--) {			// percorre o array de trás para frente
			int j = random.nextInt(i+1);					// sorteia ym indice aleatório entre 0 e i (inclusive)
			
			Estudante temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}
}
