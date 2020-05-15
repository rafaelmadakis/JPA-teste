package com.algaworks.ecommerce.conhecendoentitymanager;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Categoria;
import org.junit.Test;

public class EstadosECiclosDeVidaTest extends EntityManagerTest {

    /**
     * ciclo de vida dos objetos
     * @Autor> Rafael Madakis
     */

    @Test
    public void analisarEstados(){
        Categoria categoriaNovo = new Categoria(); // categoria nova
        Categoria categoriagerenciadaMerge = entityManager.merge(categoriaNovo); // retorno passa a ser gerenciada

        Categoria categoriaGerenciada = entityManager.find(Categoria.class,1); // Categoria gerenciada

        entityManager.remove(categoriaGerenciada); // estado removed

        entityManager.persist(categoriaGerenciada); //volta e ser gerenciada

        entityManager.detach(categoriaGerenciada); // fica desanexada

    }
}
