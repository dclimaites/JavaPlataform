package br.com.dclimaitesBot.entity;

import br.com.dclimaitesBot.contas.modelos.Conta;
import br.com.dclimaitesBot.interfaces.Instruction;
/**
 * Classe que guardará as informações do cliente do Banco
 * @author Diego Climaites
 *
 */
public class Cliente {
	private long chatId;
	private InstructionBase ultimaInstrucao;
	private Conta conta;
	/**
	 * Instancia um cliente identificando o correspondente Id do chat do telegram
	 * @param chatId ID do Chat
	 */
	public Cliente(long chatId) {
		this.chatId = chatId;
	}

	public long getChatId() {
		// TODO Auto-generated method stub
		return chatId;
	}
	/**
	 * Retorna a última intrução que o cliente executou.
	 * @return Retorna uma instrução
	 */
	public InstructionBase getUltimaInstrucao() {
		return ultimaInstrucao;
	}
	/**
	 * Atribui uma instrução como última executada pelo cliente
	 * @param ultimaInstrucao
	 */
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
