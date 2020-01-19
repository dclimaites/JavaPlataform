package br.com.fiap.contas.main;

import br.com.fiap.contas.Conta;
import br.com.fiap.contas.modelo.Banco;
import br.com.fiap.contas.modelo.ContaCorrente;

public class TestaBanco {
	public static void main(String[] args) {
		Banco banco = new Banco("Banco1", 100);
		
		Conta c1 = new ContaCorrente();
		c1.setTitular("titular1");
		c1.setNumero(1);
		c1.setAgencia("001");
		c1.deposita(1000);
		banco.adiciona(c1);
		
		Conta c2 = new ContaCorrente();
		c2.setTitular("titular2");
		c2.setNumero(2);
		c2.setAgencia("001");
		c2.deposita(1078);
		banco.adiciona(c2);
		
		Conta c3 = new ContaCorrente();
		c3.setTitular("titular3");
		c3.setNumero(3);
		c3.setAgencia("001");
		c3.deposita(4654);
		banco.adiciona(c3);
		
		Conta c4 = new ContaCorrente();
		c4.setTitular("titular4");
		c4.setNumero(4);
		c4.setAgencia("001");
		c4.deposita(8970);
		banco.adiciona(c4);
		
		banco.mostraContas();
	}
}
