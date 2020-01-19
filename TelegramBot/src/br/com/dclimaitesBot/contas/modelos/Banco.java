package br.com.dclimaitesBot.contas.modelos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.dclimaitesBot.contas.modelos.Conta;



public class Banco {

	private String nome;
	private int numero;
	private Map<String, Conta> contas;
	
	public Banco(String nome, int numero) {
		super();
		this.nome = nome;
		this.numero = numero;
		this.contas = new HashMap<String, Conta>();
	}

	/*
	 * public Conta[] getContas() { return contas; }
	 * 
	 * public void setContas(Conta[] contas) { this.contas = contas; }
	 */

	public String getNome() {
		return nome;
	}

	public int getNumero() {
		return numero;
	}
	
	public void adiciona (Conta conta) {
	
		/*
		 * for(int i =0; i < contas.length; i++){ if (contas[i] == null) contas[i] =
		 * conta; }
		 */
		this.contas.put(conta.getTitular(), conta);
	}
	
	public Conta pega(int x) {
		return contas.get(x);
	}
	
	public Conta buscarPorTitular(String nome) {
		return this.contas.get(nome);
		
	}
	
	public int pegaQuantidadeDeContas() {
		return this.contas.size();
	}
	
	public void mostraContas() {
		/* for(Conta c : this.contas) */
			System.out.println(contas);
	}
}
