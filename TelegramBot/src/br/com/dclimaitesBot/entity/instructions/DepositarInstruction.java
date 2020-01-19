package br.com.dclimaitesBot.entity.instructions;

import com.pengrad.telegrambot.request.SendMessage;

import br.com.dclimaitesBot.entity.Cliente;
import br.com.dclimaitesBot.entity.InstructionBase;
import br.com.dclimaitesBot.interfaces.Instruction;

public class DepositarInstruction extends InstructionBase {

	public DepositarInstruction(Cliente cliente) {
		super(cliente);
	}

	public DepositarInstruction(Cliente cliente, Object valor) {
		super(cliente, valor);
	}

	@Override
	public SendMessage processar() {
		// TODO Auto-generated method stub
		try {
			if(getDado() == null)
				return TratarRetornoSendMessage("Quanto deseja depositar?");
			
			double valor = Double.parseDouble((String) getDado());
			
			if (valor <= 0)
				return TratarRetornoSendMessage("Não é possível depositar esse valor");
			else {
				cliente.getConta().deposita(valor);
				cliente.setUltimaInstrucao(null);
				return TratarRetornoSendMessage("Valor depositado com sucesso. Seu saldo restante é de: " + cliente.getConta().getSaldo());
			}
		}
		catch(NumberFormatException fmtE) {
			return TratarRetornoSendMessage("O Valor informado é inválido");
		}
		catch (Exception e) {
			throw e;
		}
	}

}
