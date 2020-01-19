package br.com.fiap.contas.main;

import br.com.fiap.contas.Conta;
import br.com.fiap.contas.modelo.ContaCorrente;

public class TestaArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conta[] contas = new Conta[10];
		double saldoTotal = 0;
		for(int i = 0; i < contas.length; i++) {
			ContaCorrente conta = new ContaCorrente();
			conta.deposita(i * 100.0);
			conta.setTitular("Titular " + i);
			conta.setAgencia("0001");
			conta.setNumero(1700 + i);
			contas[i] = conta;
			saldoTotal += conta.getSaldo();
		}
		
		double mediaDoSaldo = saldoTotal/contas.length;
		System.out.println(mediaDoSaldo);
		
		
	}

}
