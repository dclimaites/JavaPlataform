package br.com.dclimaitesBot.entity.instructions;

import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;

import br.com.dclimaitesBot.contas.modelos.Conta;
import br.com.dclimaitesBot.contas.modelos.ContaCorrente;
import br.com.dclimaitesBot.contas.modelos.ContaPoupanca;
import br.com.dclimaitesBot.entity.Cliente;
import br.com.dclimaitesBot.entity.InstructionBase;
import br.com.dclimaitesBot.contas.exception.TipoContaNaoEncontradoException;

public class CadastrarInstruction extends InstructionBase<String> {

	public CadastrarInstruction(Cliente cliente) {
		super(cliente);
	}

	@Override
	public SendMessage processar() throws TipoContaNaoEncontradoException {
		// TODO Auto-generated method stub
		
		if(cliente.getConta() == null) {
			
			if(getDado() == null)
			{
				KeyboardButton[] tiposDeContas = new  KeyboardButton[2];
				tiposDeContas[0] = new KeyboardButton("Conta Corrente");
				tiposDeContas[1] = new KeyboardButton("Conta Poupança");
				ReplyKeyboardMarkup opcao = new ReplyKeyboardMarkup(tiposDeContas);
				
				return TratarRetornoSendMessageComBotoes("Que tipo de conta gostaria de abrir? \n /Corrente ou /Poupança ?", opcao);
			}
			Conta conta;
			
			if(getDado().toUpperCase().contains("CORRENTE")) {
				conta = new ContaCorrente();
			}
			else if(getDado().toUpperCase().contains("POUPANÇA"))
			{
				conta = new ContaPoupanca();
			}
			else {
				throw new TipoContaNaoEncontradoException(getDado());
			}
			
			conta.setAgencia("0001");
			conta.setNumero((int)(Math.random() * 10000));
			cliente.setConta(conta);
			cliente.setUltimaInstrucao(null);
			return TratarRetornoSendMessage("Parabéns, acaba de abrir sua conta: " + cliente.getConta());
		}
		else {
			return TratarRetornoSendMessage("Você já possui uma conta cadastrada: \n" + cliente.getConta());
		}
	}

}
