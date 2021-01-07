
nota

- Todo relacionamento toMany por padrão é carregado de forma lazy ou seja, por demanda.
Na classe TestaRelatorioMovimentacoes somente no momento da impressão das movimentações as JPA vai até o
banco fazer o carregamento daquele relacionamento.
No cenário de ralcionamento EAGER a JPA carrega todos os relacionamento de uma única vez.
Porém, tanto no relacionamento LAZY quanto no EAGER ocorre o problema de consulta N+1 que foi corrigido 
melhorando a query que busta em uma única requisição com o banco as contas e as movimentações relacionadas à elas
utilizando o join fetch. Para visualizar as contas que não possuem movimentações utilizamos o left 
na query da jpql.

