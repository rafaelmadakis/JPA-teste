package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.Test;

import javax.persistence.EntityManager;

public class OperacoesComTransacaoTest extends EntityManagerTest {

//    Produto produto = new Produto(); // Somente para o método não mostrar erros

    @Test
    public void abrirEFecharATransacao() {
        entityManager.getTransaction().begin();

//        entityManager.persist(produto);
//        entityManager.merge(produto);
//        entityManager.remove(produto);

        entityManager.getTransaction().commit();
    }

}
