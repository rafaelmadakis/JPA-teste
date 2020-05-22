package com.algaworks.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
@AllArgsConstructor // gera construtor com todos os atributos na ordem
@NoArgsConstructor // construtor padrao
public class Atributo {


    private String nome;

    private String valor;

}
