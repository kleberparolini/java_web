package br.com.alura.financas.teste;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Movimentacao mov = em.find(Movimentacao.class, 2);
		
		Conta conta = mov.getConta();
		
		System.out.println(conta.getTitular());
		System.out.println("Qtde mov: " + conta.getMovimentacoes().size());
		
		em.close();		
	}

}
