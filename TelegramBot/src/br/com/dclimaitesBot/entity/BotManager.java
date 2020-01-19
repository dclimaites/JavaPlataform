package br.com.dclimaitesBot.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;

import br.com.dclimaitesBot.interfaces.BotManagerInterface;
import br.com.dclimaitesBot.interfaces.Instruction;

import java.util.TimerTask;

public class BotManager extends TimerTask {
	private TelegramBot bot;
	private GetUpdatesResponse updatesResponse;
	private SendResponse sendResponse;
	private BaseResponse baseResponse;
	private int offSet;
	private MessageManager messageManager;
	private Map<String, Cliente> clientes;

	public BotManager() {
		bot = TelegramBotAdapter.build("988597064:AAHDM9tK1-wt52z4rfE8wqsYBFlqogTBZeA");
		offSet = 867355896;
		messageManager = new MessageManager();
		clientes = new HashMap<String, Cliente>();
	}

	@Override
	public void run() {

		try {

			// executa comando no Telegram para obter as mensagens pendentes a partir de um
			// off-set (limite inicial)
			updatesResponse = bot.execute(new GetUpdates().limit(100).offset(offSet));

			// lista de mensagens
			List<Update> updates = updatesResponse.updates();
			// análise de cada ação da mensagem
			for (Update update : updates) {
				// atualização do off-set
				offSet = update.updateId() + 1;
				// System.out.println("Recebendo mensagem:" + update.message().text());
				
				Cliente cliente = logarCliente(update.message().chat().id());
				
				SendChatAction sendMessage = new SendChatAction(cliente.getChatId(), ChatAction.typing.name());
				// envio de "Escrevendo" antes de enviar a resposta
				baseResponse = bot.execute(sendMessage);
				
				// verificação de ação de chat foi enviada com sucesso
/*				System.out.println("Resposta de Chat ActionEnviada?" + baseResponse.isOk());

				System.out.println("Últim offSet" + offSet);*/
				
				InstructionBase instruction = messageManager.TratarMensagem(update, cliente);
				
				SendMessage retorno = instruction.processar();

				// envio da mensagem de resposta
				sendResponse = bot.execute(retorno);
				// verificação de mensagem enviada com sucesso
				/* System.out.println("Mensagem Enviada?" + sendResponse.isOk()); */
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private Cliente logarCliente(long chatIdCliente) {
		Cliente cliente = clientes.get("" + chatIdCliente);
		
		if (cliente == null) {
			cliente = new Cliente(chatIdCliente);
			clientes.put("" + chatIdCliente, cliente);
		}

		return cliente;
	}
}
