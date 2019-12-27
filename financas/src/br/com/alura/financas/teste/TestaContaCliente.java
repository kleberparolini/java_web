package br.com.alura.financas.teste;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Cliente;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TestaContaCliente {

	public static void main(String[] args) {

		Cliente cliente1 = new Cliente();
		cliente1.setEndereco("Alameda Madri");
		cliente1.setNome("Joaquim III");
		cliente1.setProfissao("Pedreiro");
		cliente1.setConta(new Conta(1));
		
		Cliente cliente2 = new Cliente();
		cliente2.setEndereco("Alameda Roma");
		cliente2.setNome("João IV");
		cliente2.setProfissao("Analista de Sistemas");
		cliente2.setConta(new Conta(1));
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		//cliente 1
		em.getTransaction().begin();
		em.persist(cliente1);
		em.getTransaction().commit();
		
		//cliente 2
		
		//Dara erro, pois a classe Cliente e Conta é OnetoOne
//		em.getTransaction().begin();
//		em.persist(cliente2);
//		em.getTransaction().commit();
		
		em.close();
	}

}
