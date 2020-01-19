package br.com.fiap.contas.main;

import br.com.fiap.contas.Conta;
import br.com.fiap.contas.modelo.ContaCorrente;
import br.com.fiap.contas.modelo.ContaPoupanca;
import br.com.fiap.contas.modelo.SeguroDeVida;

public class TesteDaConta {

	public static void main(String[] args) {

		//Conta conta = new Conta();
		ContaCorrente contaCorrente = new ContaCorrente();
		ContaPoupanca contaPoupanca = new ContaPoupanca();
		SeguroDeVida seguro1 = new SeguroDeVida();
		
		System.out.println(contaCorrente.getTipo());
		System.out.println(contaPoupanca.getTipo());
		System.out.println(seguro1.getTipo());
	}

}
