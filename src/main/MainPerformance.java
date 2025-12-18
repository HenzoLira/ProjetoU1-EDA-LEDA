package main;

import java.util.concurrent.ThreadLocalRandom;

import algoritmosDeBusca.BinariaInterativa;
import algoritmosDeBusca.BinariaRecursiva;
import algoritmosDeBusca.LinearIterativa;
import algoritmosDeBusca.LinearIterativaDuasPontas;
import algoritmosDeBusca.LinearRecursiva;
import algoritmosDeOrdenacaoSlide.BubbleSort;
import algoritmosDeOrdenacaoSlide.CountingSort;
import algoritmosDeOrdenacaoSlide.InsertionSort;
import algoritmosDeOrdenacaoSlide.MergeSort;
import algoritmosDeOrdenacaoSlide.QuickSort;
import algoritmosDeOrdenacaoSlide.SelectionSort;
import algoritmosOdenacaoOtimizados.BubbleSortOtimizado;
import algoritmosOdenacaoOtimizados.QuickSortJava;
import algoritmosOdenacaoOtimizados.QuickSortShuffle;
import algoritmosOdenacaoOtimizados.SelectionSortStable;
import algoritmosOdenacaoOtimizados.TimSort;
import model.Estudante;
import util.GeradorDeDados;

public class MainPerformance {
	
	public static void main(String[] args) {
		
		int[] tamanhos = {100000};		// definidos no roteiro

		for (int n : tamanhos) {						// para cada objeto n de tamanhos :)
			System.out.println("\n=========================================");
			System.out.println("Testando com " + n + " Estudantes");
			System.out.println("=========================================");
		
			
			
																// cenário aleatório
			Estudante[] arrayParaOrdenar = GeradorDeDados.gerarArrayAleatorio(n);
			
			System.out.println("\n  - [ordenação - cenário aleatório "+ n + " elementos]" );
			rodarTodosOrdenacao(arrayParaOrdenar);
			testarQuickSortInt(n); 								// experimento extra com int[]

			
																// cenário ordenado
			Estudante[] ordenado = GeradorDeDados.gerarArrayOrdenado(n);
			
			System.out.println("\n  - [ordenação - cenário já ordenado "+ n + " elementos]");
			rodarTodosOrdenacao(ordenado);
			
			
																// cenário inverso
			Estudante[] inverso = GeradorDeDados.gerarArrayInverso(n);
			
			System.out.println("\n  - [ordenação - cenário inverso "+ n + " elementos]");
			rodarTodosOrdenacao(inverso);
			
			
			
			// Testes de busca
			int alvo = ThreadLocalRandom.current().nextInt(1, n);	// melhor performance, mais rápido que o random por evitar contenção entre threads
			System.out.println("\n  - [Busca - cenário ordenado "+ n + " elementos]"); // conforme documento
			executarTesteBusca(ordenado, alvo, "BinariaInterativa");
			executarTesteBusca(ordenado, alvo, "BinariaRecursiva");
			executarTesteBusca(ordenado, alvo, "LinearIterativa");
			executarTesteBusca(ordenado, alvo, "LinearRecursiva");
			executarTesteBusca(ordenado, alvo, "LinearIterativaDuasPontas");
		
		}
	}
	
	
	
	private static void rodarTodosOrdenacao(Estudante[] array) {
		
		// ordenações slide
		executarTesteOrdenacao(array, "BubbleSort");
		executarTesteOrdenacao(array, "SelectionSort");
		executarTesteOrdenacao(array, "InsertionSort");
		executarTesteOrdenacao(array, "MergeSort");
		executarTesteOrdenacao(array, "QuickSort");
		executarTesteOrdenacao(array, "CountingSort");
		
		// ordenações otimizadas
		executarTesteOrdenacao(array, "BubbleSortOtimizado");
		executarTesteOrdenacao(array, "QuickSortShuffle");
		executarTesteOrdenacao(array, "SelectionSortStable");
		executarTesteOrdenacao(array, "TimSort");
		
	}
	
	
	private static void executarTesteOrdenacao(Estudante[] original, String nome) {
		
		long[] tempos = new long[20];
		
		for(int i = 0; i<20; i++) {
			Estudante[] copia = original.clone();		// clona o original para que cada execução seja idêntica
			
			
			int[] notas = null;
			if(nome.contains("CountingSort")) {			// para o counting estraio apenas a nota
				notas = new int[copia.length];
				for(int j = 0; j < copia.length; j++) {
					notas[j] = copia[j].getNota();
				}
			}
			
			long t1 = System.nanoTime();
			
			// slide
			if(nome.equals("BubbleSort")) {
				BubbleSort.bubbleSort(copia);
			} else if(nome.equals("SelectionSort")) {
				SelectionSort.selectionSort(copia);
			} else if(nome.equals("InsertionSort")) {
				InsertionSort.insertionSort(copia);
			} else if(nome.equals("MergeSort")) {
				MergeSort.sort(copia);
			} else if(nome.equals("QuickSort")) {
				QuickSort.sort(copia);
			} else if(nome.equals("CountingSort")) {
				CountingSort.countingSort(copia);
			} // otimizados
			else if(nome.equals("BubbleSortOtimizado")) {
				BubbleSortOtimizado.bubbleSortOtimizado(copia);
			} else if(nome.equals("QuickSortShuffle")) {
				QuickSortShuffle.sort(copia);
			} else if(nome.equals("SelectionSortStable")) {
				SelectionSortStable.selectionSortStable(copia);;
			} else if(nome.equals("TimSort")) {
				TimSort.sort(copia);
			}
			
			long t2 = System.nanoTime();
			tempos[i] = t2 - t1;
		}
		
		imprimirMedia(tempos, nome);
	}
	
	
	private static void testarQuickSortInt(int n) {
		long[] tempos = new long[20];
		int[] originalInt = new int[n];
		for(int k = 0; k<n; k++) {
			originalInt[k] = (int)(Math.random()*n);
		}
		
		for(int i = 0; i<20; i++) {
			int[] copia = originalInt.clone();
			long t1 = System.nanoTime();
			QuickSortJava.sort(copia);
			long t2 = System.nanoTime();
			tempos[i] = t2-t1;
		}
		imprimirMedia(tempos, "QuickSortJava (primitivo int[]");
	}
	
	
	
	private static void executarTesteBusca(Estudante[] array, int alvo, String nome) {
		
		long[] tempos = new long[20];
		
		for(int i = 0; i<20; i++) {
			long t1 = System.nanoTime();
			
			if(nome.equals("BinariaInterativa")) {
				BinariaInterativa.buscar(array, alvo);
			} else if (nome.equals("BinariaRecursiva")) {
				BinariaRecursiva.buscar(array, alvo, 0, array.length-1);
			} else if (nome.equals("LinearIterativa")) {
				LinearIterativa.buscaLinearIterativa(array, alvo);
			} else if (nome.equals("LinearRecursiva")) {
				LinearRecursiva.buscar(array, alvo);
			} else if (nome.equals("LinearIterativaDuasPontas")) {
				LinearIterativaDuasPontas.buscar(array, alvo);
			}
			
			long t2 = System.nanoTime();
			
			tempos[i] = t2 - t1;
		}
		
		imprimirMedia(tempos, nome);
	}

	
	private static void imprimirMedia(long[] tempos, String nome) {
		long soma = 0;
		
		for (int i = 5; i < 20; i++) {					// começa a olhar da posição em diante (tempos)
			soma += tempos[i];
		}
		
		double mediaNano = soma/15;						// media em nanosegundos das 15 execuções
		
		double milissegundos = mediaNano / 1000000.0;	// conversões básicas
		double segundos = milissegundos / 1000.0;

		System.out.print(String.format("%-30s | Média: ", nome));
		
		if (segundos >= 600) {
			double minutos = segundos / 60.0;
			System.out.printf("%.2f min\n", minutos);
		} else if (segundos >= 10) {
			System.out.printf("%.2f s\n", segundos);
		} else {
			System.out.printf("%.4f ms\n", milissegundos);
		}
		
	}
}
