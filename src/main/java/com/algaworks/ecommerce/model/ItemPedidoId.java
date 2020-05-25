package com.algaworks.ecommerce.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ItemPedidoId  implements Serializable {

    @EqualsAndHashCode.Include
    @Column(name = "pedido_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pedidoId;

    @EqualsAndHashCode.Include
    @Column(name = "produto_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer produtoId;
}
