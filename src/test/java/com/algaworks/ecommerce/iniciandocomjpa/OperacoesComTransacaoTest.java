package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OperacoesComTransacaoTest extends EntityManagerTest {

    /**
     * Utiliando o comando detach(desanexar)
     */
    @Test
    public void impedirOperacaoComBancoDeDados() {
        Produto produto = entityManager.find(Produto.class, 1);
        entityManager.detach(produto);

        entityManager.getTransaction().begin();
        produto.setNome("Kindle segunda Geração");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertEquals("Kindle", produtoVerificacao.getNome());
    }


    /**
     * Mostra a diferença entre merge e persist
     */
    @Test
    public void mostrarDiferencaPersistMerge() {
        Produto produtoPersist = new Produto();

//        produtoPersist.setId(5); comentado porque estamos usando Identity
        produtoPersist.setNome("Smartphone One Plus");
        produtoPersist.setDescricao("O processador mais rápido");
        produtoPersist.setPreco(new BigDecimal(2000));
        produtoPersist.setDataCriacao(LocalDateTime.now());

        entityManager.getTransaction().begin();
        entityManager.persist(produtoPersist);
        produtoPersist.setNome("Smartphone Two Plus");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacaoPersist = entityManager.find(Produto.class, produtoPersist.getId());
        Assert.assertNotNull(produtoVerificacaoPersist);



        Produto produtoMerge = new Produto();

//        produtoMerge.setId(6); comentado porque estamos usando Identity
        produtoMerge.setNome("Notebook Dell");
        produtoMerge.setDescricao("O melhor da categoria");
        produtoMerge.setPreco(new BigDecimal(2000));
        produtoMerge.setDataCriacao(LocalDateTime.now());

        entityManager.getTransaction().begin();
        produtoMerge = entityManager.merge(produtoMerge);
        produtoMerge.setNome("Notebook Dell 2");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacaoMerge = entityManager.find(Produto.class, produtoMerge.getId());
        Assert.assertNotNull(produtoVerificacaoMerge);

    }

    /**
     * Faz a inserção de um produto com o merge
     */
    @Test
    public void inserirObjetoComMerge() {
        Produto produto = new Produto();

//        produto.setId(4); comentado porque estamos usando Identity
        produto.setNome("Microfone Rode Videomic");
        produto.setDescricao("A melhor qualidade de som");
        produto.setPreco(new BigDecimal(1000));
        produto.setDataCriacao(LocalDateTime.now());

        entityManager.getTransaction().begin();
        Produto produtoSalvo = entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produtoSalvo.getId());
        Assert.assertNotNull(produtoVerificacao);
    }



    /**
     * Faz a atualização de um produto gerenciado
     */
    @Test
    public void atualizarObjetoGerenciado() {
        Produto produto = entityManager.find(Produto.class, 1);

        entityManager.getTransaction().begin();
        produto.setNome("Kindle segunda Geração");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertEquals("Kindle segunda Geração", produtoVerificacao.getNome());
    }


    /**
     * Faz a atualização de um produto
     */
    @Test
    public void atualizarObjeto() {
        Produto produto = new Produto();

        produto.setId(1);
        produto.setNome("Kindle Paperwhite");
        produto.setDescricao("Conheça o novo Kindle");
        produto.setPreco(new BigDecimal(599));

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao);
        Assert.assertEquals("Kindle Paperwhite", produto.getNome());
    }

    /**
     * Faz a remoção de um produto
     */
    @Test
    public void removerObjeto() {
        // faz busca do produto para a deleção
        Produto produto = entityManager.find(Produto.class, 3);

        entityManager.getTransaction().begin();
        entityManager.remove(produto);
        entityManager.getTransaction().commit();

        Produto produtoVerificacao = entityManager.find(Produto.class, 3);
        Assert.assertNull(produtoVerificacao);
    }

    /**
     * Faz a inserção de um produto
     */
    @Test
    public void inserirOPrimeiroObjeto() {
        Produto produto = new Produto();

//        produto.setId(2); comentado porque estamos usando Identity
        produto.setNome("Câmera Canon");
        produto.setDescricao("A melhor definição para suas fotos");
        produto.setPreco(new BigDecimal(5000));
        produto.setDataCriacao(LocalDateTime.now());

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao);
    }

//    Produto produto = new Produto(); // Somente para o método não mostrar erros

    /**
     * Método de teste, sem funcionamento, somente abre e fecha transação
     */
    @Test
    public void abrirEFecharATransacao() {
        entityManager.getTransaction().begin();

//        entityManager.persist(produto);
//        entityManager.merge(produto);
//        entityManager.remove(produto);

        entityManager.getTransaction().commit();
    }

}
