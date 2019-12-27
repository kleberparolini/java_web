package br.com.alura.financas.teste;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		
		Conta conta = em.find(Conta.class, 3);
		
		System.out.println(conta);
	}

}
