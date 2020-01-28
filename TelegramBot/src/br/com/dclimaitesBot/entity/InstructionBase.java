package br.com.dclimaitesBot.entity;

import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;

import br.com.dclimaitesBot.interfaces.Instruction;
/**
 * 
 * @author Diego Climaites
 * Interface para implementa��o das instru��es executadas pelo BOT
 * @param <T>
 */
public abstract class InstructionBase<T> implements Instruction {
	protected Cliente cliente;
	private T dado;
	
	/**
	 * 
	 * @param Informa��es do cliente dentro do banco
	 */
	public InstructionBase(Cliente cliente) {
		this.cliente = cliente;
	}
	/**
	 * 
	 * @param Informa��es do cliente dentro do banco
	 * @param Dados a serem processados
	 */
	public InstructionBase(Cliente cliente, T dado) {
		this.cliente = cliente;
		this.setDado(dado);
	}
	/**
	 * Recebe uma mensagem em texto e realizar o devido tratameno da mensagem, retornando uma mensagem ao Telegram.
	 * @param Mensagem encaminhado do Telegram a API
	 * @return Mensagem processada com os dados do cliente e tratada para informa��o do cliente.
	 */
	public SendMessage TratarRetornoSendMessage(String mensagem) {
		
		
		return new SendMessage(cliente.getChatId(), mensagem);
	}
	/**
	 * Recebe uma mensagem em texto e realizar o devido tratameno da mensagem, retornando uma mensagem ao Telegram.
	 * @param Mensagem encaminhado do Telegram a API
	 * @param Op��es de bot�es que ser�o apresentadas ao usu�rio do Telegram na mensagem retornada
	 * @return Mensagem processada com os dados do cliente e tratada para informa��o do cliente.
	 */
	public SendMessage TratarRetornoSendMessageComBotoes(String mensagem, ReplyKeyboardMarkup opcao) {
		return new SendMessage(cliente.getChatId(), mensagem).replyMarkup(opcao);
	}

	public T getDado() {
		return dado;
	}

	public void setDado(T dado) {
		this.dado = dado;
	}
}
