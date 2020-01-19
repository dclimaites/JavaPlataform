package br.com.fiap.contas.modelo;

import br.com.fiap.contas.Conta;
import br.com.fiap.contas.exception.SaldoInsuficienteException;

public class ContaCorrente extends Conta implements Tributavel {

	@Override
	public void saca(double valor) throws SaldoInsuficienteException {
		
		if (valor < 0)
			throw new IllegalArgumentException("o valor deve ser maior que zero");
		
		if (valor > this.getSaldo())
			throw new SaldoInsuficienteException("o valor e maior que o saldo");
		
	    super.saca(valor + 0.1);
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return this.getClass().getSimpleName();
	}

	@Override
	public double getValorImposto() {
		// TODO Auto-generated method stub
		return this.getSaldo() * 0.01;
	}
}
