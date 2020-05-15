package com.algaworks.ecommerce;

import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.StatusPedido;
import org.junit.Test;

public class FlushTest  extends EntityManagerTest {

    @Test(expected = Exception.class)
    public void chamarFlush() {
        try {
            entityManager.getTransaction().begin();

            Pedido pedido = entityManager.find(Pedido.class, 1);
            pedido.setStatus(StatusPedido.PAGO);

//            entityManager.flush(); //obriga a sincronizar com o banco, igual o commit, mas no flush força um pouco antes

            if (pedido.getPagamento() == null) {
                throw  new RuntimeException("O pedido ainda não foi pago");
            }
        }catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw  e;
        }
    }

}
