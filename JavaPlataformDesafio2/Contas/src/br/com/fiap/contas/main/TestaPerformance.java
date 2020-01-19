package br.com.fiap.contas.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class TestaPerformance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  testaPerformanceArrayList(); 
		  testaPerformanceLinkedList();
		  testaPerformanceHashSet();
		 
		
		/*
		 * testaPerformanceArrayListNaPrimeiraPosicao();
		 * testaPerformanceLinkedListNaPrimeiraPosicao();
		 */
	}

	public static void testaPerformanceLinkedList() {
		System.out.println("Iniciando LinkedList...");

		List<Integer> teste = new LinkedList<>();
		long inicio = System.currentTimeMillis();
		long inicioFor, fimFor;
		int total = 30000;

		inicioFor = System.currentTimeMillis();

		for (int i = 0; i < total; i++) {
			teste.add(i);
		}

		fimFor = System.currentTimeMillis();

		System.out.println("Tempo do for de inserção " + (fimFor - inicioFor));

		inicioFor = System.currentTimeMillis();

		for (int i = 0; i < total; i++) {
			 teste.contains(i); 
			//teste.get(i);
		}

		fimFor = System.currentTimeMillis();
		System.out.println("Tempo do for de busca " + (fimFor - inicioFor));

		long fim = System.currentTimeMillis();
		long tempo = fim - inicio;
		System.out.println("Tempo gasto ArrayList: " + tempo);
	}
	
	public static void testaPerformanceLinkedListNaPrimeiraPosicao() {
		System.out.println("Iniciando LinkedList na primeira posição...");

		List<Integer> teste = new LinkedList<>();
		long inicio = System.currentTimeMillis();
		long inicioFor, fimFor;
		int total = 30000;

		inicioFor = System.currentTimeMillis();

		for (int i = 0; i < total; i++) {
			teste.add(0, i);
		}

		fimFor = System.currentTimeMillis();

		System.out.println("Tempo do for de inserção " + (fimFor - inicioFor));

		inicioFor = System.currentTimeMillis();

		for (int i = 0; i < total; i++) {
			teste.contains(i);
		}

		fimFor = System.currentTimeMillis();
		System.out.println("Tempo do for de busca " + (fimFor - inicioFor));

		long fim = System.currentTimeMillis();
		long tempo = fim - inicio;
		System.out.println("Tempo gasto ArrayList: " + tempo);
	}

	public static void testaPerformanceArrayListNaPrimeiraPosicao() {
		System.out.println("Iniciando LinkedList na primeira posição...");

		List<Integer> teste = new ArrayList<>();
		long inicio = System.currentTimeMillis();
		long inicioFor, fimFor;
		int total = 30000;

		inicioFor = System.currentTimeMillis();

		for (int i = 0; i < total; i++) {
			teste.add(0, i);
		}

		fimFor = System.currentTimeMillis();

		System.out.println("Tempo do for de inserção " + (fimFor - inicioFor));

		inicioFor = System.currentTimeMillis();

		for (int i = 0; i < total; i++) {
			teste.contains(i);
		}

		fimFor = System.currentTimeMillis();
		System.out.println("Tempo do for de busca " + (fimFor - inicioFor));

		long fim = System.currentTimeMillis();
		long tempo = fim - inicio;
		System.out.println("Tempo gasto ArrayList: " + tempo);
	}

	
	public static void testaPerformanceArrayList() {
		System.out.println("Iniciando ArrayList...");

		List<Integer> teste = new ArrayList<>();
		long inicio = System.currentTimeMillis();
		long inicioFor, fimFor;
		int total = 30000;

		inicioFor = System.currentTimeMillis();

		for (int i = 0; i < total; i++) {
			teste.add(i);
		}

		fimFor = System.currentTimeMillis();

		System.out.println("Tempo do for de inserção " + (fimFor - inicioFor));

		inicioFor = System.currentTimeMillis();

		for (int i = 0; i < total; i++) {
			 teste.contains(i); 
			/* teste.get(i); */
		}

		fimFor = System.currentTimeMillis();
		System.out.println("Tempo do for de busca " + (fimFor - inicioFor));

		long fim = System.currentTimeMillis();
		long tempo = fim - inicio;
		System.out.println("Tempo gasto ArrayList: " + tempo);
	}

	public static void testaPerformanceHashSet() {
		System.out.println("Iniciando HashSet...");

		Collection<Integer> teste = new HashSet<>();
		long inicio = System.currentTimeMillis();
		long inicioFor, fimFor;

		int total = 30000;

		inicioFor = System.currentTimeMillis();

		for (int i = 0; i < total; i++) {
			teste.add(i);
		}

		fimFor = System.currentTimeMillis();

		System.out.println("Tempo do for de inserção " + (fimFor - inicioFor));

		inicioFor = System.currentTimeMillis();

		for (int i = 0; i < total; i++) {
			teste.contains(i);
		}

		fimFor = System.currentTimeMillis();
		System.out.println("Tempo do for de busca " + (fimFor - inicioFor));

		long fim = System.currentTimeMillis();
		long tempo = fim - inicio;
		System.out.println("Tempo gasto ArrayList: " + tempo);
	}

}
