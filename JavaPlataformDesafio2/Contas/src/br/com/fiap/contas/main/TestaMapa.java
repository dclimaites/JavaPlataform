package br.com.fiap.contas.main;

import java.util.HashMap;
import java.util.Map;

import br.com.fiap.contas.Conta;
import br.com.fiap.contas.modelo.ContaCorrente;

public class TestaMapa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conta c1 = new ContaCorrente();
		c1.deposita(20000);
		
		Conta c2 = new ContaCorrente();
		c2.deposita(1000);
		
		Map<String, Conta> mapaDeContas = new HashMap();
		
		mapaDeContas.put("diretor", c1);
		mapaDeContas.put("gerente", c2);
		
		Conta contaDiretor = mapaDeContas.get("diretor");
		System.out.println(contaDiretor.getSaldo());
	}

}

