package com.algaworks.ecommerce.mapeamentoavancado;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;

public class MapsIdTest extends EntityManagerTest {


    @Test
    public void inserirPagamento() {
        Pedido pedido = entityManager.find(Pedido.class, 1);

        NotaFiscal notaFiscal = new NotaFiscal();
//        notaFiscal.setId(pedido.getId()); @MapsId
        notaFiscal.setPedido(pedido);
        notaFiscal.setDataEmissao(new Date());
        notaFiscal.setXml("<xml/>".getBytes());

        entityManager.getTransaction().begin();
        entityManager.persist(notaFiscal);
        entityManager.getTransaction().commit();

        entityManager.clear();

        NotaFiscal notaFiscalVerificacao = entityManager.find(NotaFiscal.class, notaFiscal.getId());
        Assert.assertNotNull(notaFiscalVerificacao); // verifica se o pedido foi inserido
        Assert.assertEquals(pedido.getId(), notaFiscalVerificacao.getId()); // veirifica se o identificador da nota fiscal é o mesmo do pedido
    }

    @Test
    public void inserirItemPedido() {
        Cliente cliente = entityManager.find(Cliente.class, 1);
        Produto produto = entityManager.find(Produto.class, 1);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataCriacao(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setTotal(produto.getPreco());

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setId(new ItemPedidoId());
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);
        itemPedido.setPrecoProduto(produto.getPreco());
        itemPedido.setQuantidade(1);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.persist(itemPedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        ItemPedido itemPedidoVerificacao = entityManager.find(
                ItemPedido.class, new ItemPedidoId(pedido.getId(), produto.getId()));
        Assert.assertNotNull(itemPedidoVerificacao);
    }



}
