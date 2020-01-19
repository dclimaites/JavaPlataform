package br.com.dclimaitesBot.contas.modelos;

import br.com.dclimaitesBot.contas.interfaces.Tributavel;

public class SeguroDeVida implements Tributavel {
	
	private double valor;
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getNumeroApolice() {
		return numeroApolice;
	}

	public void setNumeroApolice(int numeroApolice) {
		this.numeroApolice = numeroApolice;
	}

	private String titular;
	private int numeroApolice;

	@Override
	public double getValorImposto() {
		// TODO Auto-generated method stub
		return 42 + this.getValor() * 0.02;
	}
	
	public String getTipo() {
		return "Seguro de Vida";
	}
	
}
