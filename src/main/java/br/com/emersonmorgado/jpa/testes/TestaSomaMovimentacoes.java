package br.com.emersonmorgado.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import br.com.emersonmorgado.jpa.modelo.Movimentacao;

public class TestaSomaMovimentacoes {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("estudo_jpa");
		EntityManager em = emf.createEntityManager();
		
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);
		
		Root<Movimentacao> root = query.from(Movimentacao.class);
		
		Expression<BigDecimal> sum = builder.sum(root.<BigDecimal>get("valor"));
		query.select(sum);
		
		TypedQuery<BigDecimal> typedQuery = em.createQuery(query);
		
		System.out.println("A soma das movimentações é: " + typedQuery.getSingleResult());
//		
		
//		MovimentacaoDao dao = new MovimentacaoDao(em);
//		
//		BigDecimal somaMovimentacoes = dao.getSomaDasMovimentacoes();
//		System.out.println("A soma das movimentações é: " + somaMovimentacoes);
//		
//		
//		Double mediaMovimentacoes = dao.getMediaMovimentacao();
//		System.out.println("A média das movimentações é: " + mediaMovimentacoes);
//		
	}

}
