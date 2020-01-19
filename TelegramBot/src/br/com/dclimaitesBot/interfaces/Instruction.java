package br.com.dclimaitesBot.interfaces;

import com.pengrad.telegrambot.request.SendMessage;

public interface Instruction {
	SendMessage processar() throws Exception;
}