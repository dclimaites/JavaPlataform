package br.com.fiap.contas.main;

import br.com.fiap.contas.modelo.ContaCorrente;
import br.com.fiap.contas.modelo.ContaPoupanca;
import br.com.fiap.contas.modelo.SeguroDeVida;
import br.com.fiap.contas.modelo.Tributavel;

public class TestaTributavel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContaCorrente contaCorrente = new ContaCorrente();
		SeguroDeVida seguro1 = new SeguroDeVida();
		contaCorrente.deposita(100);
		System.out.println(contaCorrente.getValorImposto());
		
		Tributavel trib = contaCorrente;
		System.out.println(trib.getValorImposto());
	}

}
