import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.caelum.JpaConfigurator;
import br.com.caelum.model.Produto;

public class TestaCache {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfigurator.class);
		
		EntityManagerFactory emf =  ctx.getBean(EntityManagerFactory.class);
		
		EntityManager em1 = emf.createEntityManager();
		Produto p = em1.find(Produto.class, 1);	
		
		EntityManager em2 = emf.createEntityManager();
		Produto p2 = em2.find(Produto.class, 1);
		
		System.out.println(p.getNome());
		System.out.println(p2.getNome());
		
		em1.close();
		em2.close();
		
	}

}
