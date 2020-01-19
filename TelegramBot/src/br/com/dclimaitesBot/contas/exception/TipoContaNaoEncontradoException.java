package br.com.dclimaitesBot.contas.exception;

public class TipoContaNaoEncontradoException extends Exception {

	private static final long serialVersionUID = 1L;

	/*
	 * public TipoContaNaoEncontradoException(String tipoConta) { super("o valor " +
	 * tipoConta + " esta maior que o saldo"); }
	 */

	public TipoContaNaoEncontradoException(String message) {
		super("Tipo de conta " + message + " não encontrada.");

	}

}
