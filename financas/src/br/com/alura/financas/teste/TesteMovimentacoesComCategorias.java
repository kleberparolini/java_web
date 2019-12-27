package br.com.alura.financas.teste;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Categoria;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteMovimentacoesComCategorias {

	public static void main(String[] args) {

		Categoria categoria1 = new  Categoria("Viagem");
		Categoria categoria2 = new  Categoria("Negocios");
		
		List<Categoria> categorias = new ArrayList<>();
		
		categorias.add(categoria1);
		categorias.add(categoria2);
		
		Conta conta = new Conta();
		conta.setId(1);
		
		Movimentacao mov1 = new Movimentacao();
		mov1.setValor(new BigDecimal("100.0"));
		mov1.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		mov1.setData(Calendar.getInstance());
		mov1.setDescricao("Viagem trabalho");
		mov1.setCategoria(categorias);
		mov1.setConta(conta);
		
		
		Movimentacao mov2 = new Movimentacao();
		mov2.setValor(new BigDecimal("300.0"));
		mov2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		mov2.setData(Calendar.getInstance());
		mov2.setDescricao("Viagem lazer");
		mov2.setCategoria(categorias);
		mov2.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(categoria1);
		em.persist(categoria2);
		em.persist(mov1);
		em.persist(mov2);
		
//		Movimentacao movManaged1 = em.find(Movimentacao.class, 25);
//		movManaged1.setConta(conta);
//		em.persist(movManaged1);
//		
//		
//		Movimentacao movManaged2 = em.find(Movimentacao.class, 26);
//		movManaged2.setConta(conta);
//		em.persist(movManaged2);
		
		em.getTransaction().commit();
		em.close();
	}

}
