package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.financas.dao.MovimentacaoDao;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteMediaMovimentacaoPorDia {

	public static void main(String[] args) {

		Conta conta = new Conta(1);
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		MovimentacaoDao movDao = new  MovimentacaoDao(em);
		
		List<Double> medias = movDao.getMediasPorDia(TipoMovimentacao.SAIDA, conta);
		
		for (Double media : medias) {
			System.out.println("Media: " + media);
		}
		
		em.getTransaction().commit();
		
		em.close();
	}

}
