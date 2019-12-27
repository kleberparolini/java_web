package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Categoria;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteJPQLMovimentacaoCategoria {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";
		
		Query query  = em.createQuery(jpql);
		
		Categoria cat = new Categoria();
		cat.setId(1);
		
		query.setParameter("pCategoria", cat);
		
		List<Movimentacao> movimentacoes = query.getResultList();
		
		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("Id: " + movimentacao.getId() + 
					"\nDescrição: " + movimentacao.getDescricao());
		}
		
		em.close();
	}
}
