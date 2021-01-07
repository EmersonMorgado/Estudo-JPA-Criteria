package br.com.emersonmorgado.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestaMediaDiariaMovimentacoesObject {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("estudo_jpa");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select avg(m.valor), day(m.data), month(m.data) from Movimentacao m group by day(m.data), month(m.data), year(m.data)";
		
		Query query = em.createQuery(jpql);
		List<Object[]> mediaMovimentacoes = query.getResultList();
		for (Object[] resultado : mediaMovimentacoes) {
			System.out.println("A média das movimentações do dia " + resultado[1] + 
					"/" + resultado[2] + " é: " + resultado[0]);			
		}
	}
}
