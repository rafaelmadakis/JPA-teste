package com.algaworks.ecommerce.conhecendoentitymanager;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.StatusPedido;
import org.junit.Test;


/**
 * Gerenciamento de transações
 */
public class GerenciamentoTransacoesTest extends EntityManagerTest {

    @Test(expected = Exception.class) // espera uma exception
    public void abrirFecharCancelarTransacao() {

        try {
            entityManager.getTransaction().begin();
            metodoDeNegocio();
            entityManager.getTransaction().commit();

        }catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;

        }

        /*
        Situação onde se encaixa o rollback
         */
//        Pedido pedido = entityManager.find(Pedido.class, 1);
//
//        entityManager.getTransaction().begin();
//        pedido.setStatus(StatusPedido.PAGO);
//
//        if (pedido.getPagamento() != null) {
//            entityManager.getTransaction().commit();
//        } else {
//            entityManager.getTransaction().rollback();
//        }


    }

    private void metodoDeNegocio() {

        Pedido pedido = entityManager.find(Pedido.class, 1);
        pedido.setStatus(StatusPedido.PAGO);

        if (pedido.getPagamento() == null) {
                throw  new RuntimeException("Pedido ainda não foi pago.");
        } else {

        }

    }
}
