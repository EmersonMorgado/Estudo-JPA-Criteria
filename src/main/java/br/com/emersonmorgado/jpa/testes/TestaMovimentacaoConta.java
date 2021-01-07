package br.com.emersonmorgado.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.emersonmorgado.jpa.modelo.Conta;
import br.com.emersonmorgado.jpa.modelo.Movimentacao;

public class TestaMovimentacaoConta {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("estudo_jpa");
		EntityManager em = emf.createEntityManager();
		
		Movimentacao movimentacao = em.find(Movimentacao.class, 1L);
		Conta conta =  movimentacao.getConta();
		
		int quantidadeMovimentacoes = conta.getMovimentacao().size();
		
		System.out.println("Quantidade de movimentacoes: " + quantidadeMovimentacoes);
		System.out.println("Titular da Conta: " + conta.getTitular());

	}

}
