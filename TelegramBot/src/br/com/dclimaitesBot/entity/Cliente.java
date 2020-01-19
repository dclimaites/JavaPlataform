package br.com.dclimaitesBot.entity;

import br.com.dclimaitesBot.contas.modelos.Conta;
import br.com.dclimaitesBot.interfaces.Instruction;

public class Cliente {
	private long chatId;
	private InstructionBase ultimaInstrucao;
	private Conta conta;
	
	public Cliente(long chatId) {
		this.chatId = chatId;
	}

	public long getChatId() {
		// TODO Auto-generated method stub
		return chatId;
	}

	public InstructionBase getUltimaInstrucao() {
		return ultimaInstrucao;
	}

	public void setUltimaInstrucao(InstructionBase ultimaInstrucao) {
		this.ultimaInstrucao = ultimaInstrucao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
