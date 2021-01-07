package br.com.emersonmorgado.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.emersonmorgado.jpa.modelo.Movimentacao;
import br.com.emersonmorgado.jpa.modelo.dao.MovimentacaoDao;

public class TesteMovimentacoesFiltradasPorDataCriteria {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("estudo_jpa");
		EntityManager em = emf.createEntityManager();
		
		MovimentacaoDao movimentacaoDao = new MovimentacaoDao(em);
		List<Movimentacao> movimentacoesFiltradasPorData = movimentacaoDao.getMovimentacoesFiltradasPorData(null, null, null);
		
		for (Movimentacao movimentacao : movimentacoesFiltradasPorData) {
			System.out.println("Descrição -> " + movimentacao.getDescricao());
			System.out.println("Valor -> " + movimentacao.getValor());
			System.out.println("--------------------------------------------");	
		}
	}
}
