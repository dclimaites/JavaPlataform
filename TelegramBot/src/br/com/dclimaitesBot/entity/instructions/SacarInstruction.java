package br.com.dclimaitesBot.entity.instructions;

import com.pengrad.telegrambot.request.SendMessage;

import br.com.dclimaitesBot.contas.exception.SaldoInsuficienteException;
import br.com.dclimaitesBot.entity.Cliente;
import br.com.dclimaitesBot.entity.InstructionBase;

public class SacarInstruction extends InstructionBase {

	public SacarInstruction(Cliente cliente) {
		super(cliente);
		// TODO Auto-generated constructor stub
	}
	
	public SacarInstruction(Cliente cliente, Object valor) {
		super(cliente, valor);
	}

	@Override
	public SendMessage processar() throws Exception {
		// TODO Auto-generated method stub
		try {
			if(getDado() == null)
				return TratarRetornoSendMessage("Quanto deseja sacar?");
			
			double valor = Double.parseDouble((String) getDado());
			
			if (valor <= 0)
				return TratarRetornoSendMessage("Não é possível sacar esse valor");
			else {
				cliente.getConta().saca(valor);
				cliente.setUltimaInstrucao(null);
				return TratarRetornoSendMessage("Valor sacado com sucesso. Seu saldo restante é de: " + cliente.getConta().getSaldo());
			}
		}
		catch(NumberFormatException fmtE) {
			return TratarRetornoSendMessage("O Valor informado é inválido");
		}
		catch (SaldoInsuficienteException saldoInsuficiente) {
			return TratarRetornoSendMessage(saldoInsuficiente.getMessage());
		}
		catch (Exception e) {
			throw e;
		}
	}

}
