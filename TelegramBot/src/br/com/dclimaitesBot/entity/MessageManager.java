package br.com.dclimaitesBot.entity;

import java.util.Collection;
import java.util.HashSet;

import com.pengrad.telegrambot.model.Update;

import br.com.dclimaitesBot.entity.instructions.CadastrarInstruction;
import br.com.dclimaitesBot.entity.instructions.DepositarInstruction;
import br.com.dclimaitesBot.entity.instructions.NaoDefinidoInstruction;
import br.com.dclimaitesBot.entity.instructions.SacarInstruction;
import br.com.dclimaitesBot.interfaces.Instruction;

public class MessageManager {
	private Collection<String> comandosDoUsuario;

	public MessageManager() {
		comandosDoUsuario = new HashSet<String>();

		comandosDoUsuario.add("/sacar");
		comandosDoUsuario.add("/depositar");
	}

	public InstructionBase TratarMensagem(Update userMessage, Cliente cliente) {
		String mensagem = userMessage.message().text();
		
		if (isInstruction(mensagem))
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
		else {
			InstructionBase ultimaInstrucoDoCliente = cliente.getUltimaInstrucao();
			if (ultimaInstrucoDoCliente != null) {
				ultimaInstrucoDoCliente.setDado(mensagem);
				return cliente.getUltimaInstrucao();
			}
				
		}

		return new NaoDefinidoInstruction(cliente);
	}

	private boolean isInstruction(String texto) {
		if (!texto.isEmpty() && texto.startsWith("/"))
			return true;
		else
			return false;
	}

}
