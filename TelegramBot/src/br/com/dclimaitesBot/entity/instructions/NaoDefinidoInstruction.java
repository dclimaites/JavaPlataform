package br.com.dclimaitesBot.entity.instructions;

import com.pengrad.telegrambot.request.SendMessage;

import br.com.dclimaitesBot.entity.Cliente;
import br.com.dclimaitesBot.entity.InstructionBase;
import br.com.dclimaitesBot.interfaces.Instruction;

public class NaoDefinidoInstruction extends InstructionBase implements Instruction {

	public NaoDefinidoInstruction(Cliente cliente) {
		super(cliente);
		// TODO Auto-generated constructor stub
	}

	@Override
	public SendMessage processar() {
		// TODO Auto-generated method stub
		return new SendMessage(cliente.getChatId(), "Opção não encontrada. \nUse uma das opções abaixo:\n /cadastrar\n /depositar\n /sacar");
	}

}
