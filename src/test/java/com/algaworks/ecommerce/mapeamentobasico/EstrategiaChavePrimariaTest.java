package com.algaworks.ecommerce.mapeamentobasico;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Categoria;
import org.junit.Assert;
import org.junit.Test;

public class EstrategiaChavePrimariaTest extends EntityManagerTest {

    @Test
    public void testarEstrategiaAuto() {
        Categoria categoria = new Categoria();
        categoria.setNome("Eletrônicos");

        entityManager.getTransaction().begin();
        entityManager.persist(categoria);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Categoria categariaVerificacao = entityManager.find(Categoria.class, categoria.getId());

        Assert.assertNotNull(categariaVerificacao);
    }
    @Test
    public void testarEstrategiaChave() {
        Categoria categoria = new Categoria();
        categoria.setNome("Natação");

        entityManager.getTransaction().begin();
        entityManager.persist(categoria);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Categoria categariaVerificacao = entityManager.find(Categoria.class, categoria.getId());

        Assert.assertNotNull(categariaVerificacao);
    }

    @Test
    public void testarEstrategiaTable() {
        Categoria categoria = new Categoria();
        categoria.setNome("Eletrônicos");

        entityManager.getTransaction().begin();
        entityManager.persist(categoria);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Categoria categariaVerificacao = entityManager.find(Categoria.class, categoria.getId());

        Assert.assertNotNull(categariaVerificacao);
    }

    @Test
    public void testarEstrategiaIdentity() {
        Categoria categoria = new Categoria();
        categoria.setNome("Eletrônicos 2");

        entityManager.getTransaction().begin();
        entityManager.persist(categoria);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Categoria categariaVerificacao = entityManager.find(Categoria.class, categoria.getId());

        Assert.assertNotNull(categariaVerificacao);
    }

}
