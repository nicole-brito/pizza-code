package com.soulcode.pizzacode2.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaDTO {

    private Long idPizza;
    private String nome;
    private Double precoBase;
    private Boolean personalizada;
}
