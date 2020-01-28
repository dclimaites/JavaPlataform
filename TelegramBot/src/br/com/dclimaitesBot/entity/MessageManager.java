package br.com.dclimaitesBot.entity;

import java.util.Collection;
import java.util.HashSet;

import com.pengrad.telegrambot.model.Update;

import br.com.dclimaitesBot.entity.instructions.CadastrarInstruction;
import br.com.dclimaitesBot.entity.instructions.DepositarInstruction;
import br.com.dclimaitesBot.entity.instructions.NaoDefinidoInstruction;
import br.com.dclimaitesBot.entity.instructions.SacarInstruction;
import br.com.dclimaitesBot.interfaces.Instruction;

/**
 * Realizar o tratamento e gerenciamento das mensagens entre as regras de negócio do sistema e o Telegram.
 * @author Diego Climaites
 *
 */
public class MessageManager {
	private Collection<String> comandosDoUsuario;

	public MessageManager() {
		comandosDoUsuario = new HashSet<String>();

		comandosDoUsuario.add("/sacar");
		comandosDoUsuario.add("/depositar");
	}
	/**
	 * Realiza o tratamento das instruções recebendo os dados do cliente.
	 * @param userMessage Mensagem que será enviada ao Telegram do cliente que solicitou a instrução.
	 * @param cliente Dados do cliente cadastrado dentro do Banco.
	 * @return Retorna uma instrução a ser executada conforme a implementação. 
	 */
	public InstructionBase TratarMensagem(Update userMessage, Cliente cliente) {
		String mensagem = userMessage.message().text();
		
		if (isInstruction(mensagem)) {
			switch (mensagem) {
			case "/cadastrar":
				cliente.setUltimaInstrucao(new CadastrarInstruction(cliente));
				return cliente.getUltimaInstrucao();
			case "/depositar":
				cliente.setUltimaInstrucao(new DepositarInstruction(cliente));
				return cliente.getUltimaInstrucao();
			case "/sacar":
				cliente.setUltimaInstrucao(new SacarInstruction(cliente));
				return cliente.getUltimaInstrucao();
			}
		}
		else {
			InstructionBase ultimaInstrucoDoCliente = cliente.getUltimaInstrucao();
			if (ultimaInstrucoDoCliente != null) {
				ultimaInstrucoDoCliente.setDado(mensagem);
				return cliente.getUltimaInstrucao();
			}
				
		}

		return new NaoDefinidoInstruction(cliente);
	}
	/**
	 * Faz a validação se a mensagem encaminhada pelo usuário é de fato uma instrução a ser realizada.
	 * @param texto Texto encaminhado pelo Telegram
	 * @return 
	 */
	private boolean isInstruction(String texto) {
		if (!texto.isEmpty() && texto.startsWith("/"))
			return true;
		else
			return false;
	}

}
