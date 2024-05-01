package com.soulcode.pizzacode2.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    @Column(nullable = false)
    private Date dataHora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idFornada", nullable = false)
    private Fornada fornadas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente clientes;

    @OneToMany(mappedBy = "pedidos")
    private Set<BebidaPedida> IdPedidoBebidasPedidas;

    @OneToMany(mappedBy = "pedidos")
    private Set<PizzaPedida> IdPedidoPizzasPedidas;

}