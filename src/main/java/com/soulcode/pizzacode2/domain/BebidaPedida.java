package com.soulcode.pizzacode2.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bebidasPedidas")
public class BebidaPedida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBebidaPedida;

    @Column(nullable = false)
    private Integer quantidade;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idBebidas", nullable = false)
    private Bebida bebidas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPedidos", nullable = false)
    private Pedido pedidos;
}