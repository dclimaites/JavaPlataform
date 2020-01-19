package br.com.dclimaitesBot.contas.exception;

public class SaldoInsuficienteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SaldoInsuficienteException() {

	}
	
	public SaldoInsuficienteException(double valor) {
			super("o valor " + valor + " esta maior que o saldo");
	}
	
	public SaldoInsuficienteException(String message) {
		super(message);

	}
}
