package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		String jpql = "select m from " +
		"Movimentacao m where m.conta = :pConta " +
		"and m.tipoMovimentacao = :pTipoMovimentacao " +
		"order by m.conta desc";
		
		Query query  = em.createQuery(jpql);
		
		query.setParameter("pConta", new Conta(1));
		query.setParameter("pTipoMovimentacao", TipoMovimentacao.SAIDA);
		
		List<Movimentacao> movimentacoes = query.getResultList();
		
		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("Id: " + movimentacao.getId() + 
					"\nDescrição: " + movimentacao.getDescricao());
		}
		
		em.close();
	}
}
