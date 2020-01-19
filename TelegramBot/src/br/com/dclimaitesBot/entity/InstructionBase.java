package br.com.dclimaitesBot.entity;

import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;

import br.com.dclimaitesBot.interfaces.Instruction;

public abstract class InstructionBase<T> implements Instruction {
	protected Cliente cliente;
	private T dado;
	
	public InstructionBase(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public InstructionBase(Cliente cliente, T dado) {
		this.cliente = cliente;
		this.setDado(dado);
	}
	
	public SendMessage TratarRetornoSendMessage(String mensagem) {
		
		
		return new SendMessage(cliente.getChatId(), mensagem);
	}
	
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
