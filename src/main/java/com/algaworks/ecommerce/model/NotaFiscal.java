package com.algaworks.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal extends EntidadeBaseInteger {

//    @EqualsAndHashCode.Include
//    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "pedido_id")
//    private Integer id;

    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name = "pedido_id")
//    @JoinTable(name = "pedido_nota_fiscal",
//            joinColumns = @JoinColumn(name = "nota_fiscal_id", unique = true),
//            inverseJoinColumns = @JoinColumn(name = "pedido_id", unique = true))
    private Pedido pedido;

    @Column(nullable = false)
    @Lob
    private byte[] xml;

    @Column(name = "data_emissao", nullable = false)
    private Date dataEmissao;
}