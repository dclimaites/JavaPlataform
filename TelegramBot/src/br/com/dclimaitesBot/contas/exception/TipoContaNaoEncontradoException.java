package br.com.dclimaitesBot.contas.exception;

/**
 * Exce��o para mensagem quando o tipo de conta n�o for encontrado
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
		super("Tipo de conta " + message + " n�o encontrada.");

	}

}
