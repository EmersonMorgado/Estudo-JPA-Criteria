package br.com.emersonmorgado.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.emersonmorgado.jpa.modelo.MediaComData;
import br.com.emersonmorgado.jpa.modelo.dao.MovimentacaoDao;

public class TestaMediaDiariaMovimentacoes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("estudo_jpa");
		EntityManager em = emf.createEntityManager();

		List<MediaComData> mediaMovimentacoes = new MovimentacaoDao(em).getMediaDiariaMovimentacoes();
		for (MediaComData resultado : mediaMovimentacoes) {
			System.out.println("A média das movimentações do dia " + resultado.getDia() + 
					"/" + resultado.getMes() + " é: " + resultado.getValor());			
		}
	}
}
