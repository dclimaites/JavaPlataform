package br.com.dclimaitesBot.contas.modelos;

import br.com.dclimaitesBot.contas.exception.SaldoInsuficienteException;
/**
 * Classe com as informações de conta
 * @author Diego Climaites
 *
 */
public abstract class Conta implements Comparable<Conta> {

	private double saldo;
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	private int numero;
	private String titular;
	private String agencia;
	/**
	 * Deposita valor na conta do cliente, aumentando o saldo
	 * @param valor a depositar
	 */
	public void deposita(double valor) {
		if (valor < 0)
			throw new IllegalArgumentException("o valor deve ser maior que zero");
		
		this.saldo += valor;
	}
	/**
	 * Saca o valor do saldo do cliente, podendo emitir uma exceção caso o valor seja maior que o saldo disponível na conta
	 * @param Valor a ser sacado.
	 * @throws SaldoInsuficienteException
	 */
	public void saca(double valor) throws SaldoInsuficienteException {
		if(valor > saldo)
			throw new SaldoInsuficienteException(valor);
		
		this.saldo -= valor;
	}
	/**
	 * Transfere o valor da conta atual para a conta destino, podendo emitir uma exceção caso o valor seja maior que o saldo disponível na conta
	 * @param Valor a ser transferido
	 * @param conta destino que receberá o valor
	 * @throws SaldoInsuficienteException 
	 */
	public void transfere(double valor, Conta conta) throws SaldoInsuficienteException {
		this.saca(valor);
		if (conta != null)
			conta.deposita(valor);
		else
			throw new IllegalArgumentException("A conta nao deve ser nula");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result + numero;
		long temp;
		temp = Double.doubleToLongBits(saldo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((titular == null) ? 0 : titular.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
	   if (obj == null)
		   return false;
	   
	   Conta outraConta = (Conta) obj;
	   return this.numero == outraConta.numero && this.agencia.equalsIgnoreCase(outraConta.getAgencia());	   
	}

	@Override
	public String toString() {
		return "Agência: " + this.agencia + " Conta: " + this.numero;
	}
	
	public int compareTo(Conta outraConta) {
		return this.titular.compareTo(outraConta.titular);
	}

	public abstract String getTipo();

//	public String getTipo() {
//		return this.getClass().getSimpleName();
//		
//	}
}
