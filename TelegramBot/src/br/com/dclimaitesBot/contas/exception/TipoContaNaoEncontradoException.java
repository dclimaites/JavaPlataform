package br.com.dclimaitesBot.contas.exception;

/**
 * Exceção para mensagem quando o tipo de conta não for encontrado
 * @author Diego Climaites
 *
 */
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
