package br.com.fiap.contas.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import br.com.fiap.contas.Conta;
import br.com.fiap.contas.modelo.ContaCorrente;

public class TestaLista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testaArrayList();
		testaLinkedList();
	}
	
	public static void testaArrayList() {
		List<Conta> contas = new ArrayList<>();
		
		for (int i = 0; i < 20; i++) {
			ContaCorrente conta = new ContaCorrente();
			conta.deposita(Math.random() * 1000.0);
			conta.setTitular("Titular " + (int)(Math.random() * 100));
			conta.setAgencia("0001");
			conta.setNumero(1700 + i);
			contas.add(conta);
			System.out.println(conta);
		}
		
		
		
		Collections.sort(contas);
		System.out.println("Exibindo as contas ordenadas por titular");
		for(Conta c : contas) {
			System.out.println(c);
		}
		
		System.out.println("Referência da lista");
		System.out.println(contas);
	}
	
	public static void testaLinkedList() {
		List<Conta> contas = new LinkedList<>();
		
		for (int i = 0; i < 20; i++) {
			ContaCorrente conta = new ContaCorrente();
			conta.deposita(Math.random() * 1000.0);
			conta.setTitular("Titular " + (int)(Math.random() * 100));
			conta.setAgencia("0001");
			conta.setNumero(1700 + i);
			contas.add(conta);
			System.out.println(conta);
		}
		
		
		
		Collections.sort(contas);
		System.out.println("Exibindo as contas ordenadas por titular");
		for(Conta c : contas) {
			System.out.println(c);
		}
		
		System.out.println("Referência da lista");
		System.out.println(contas);
	}

}
