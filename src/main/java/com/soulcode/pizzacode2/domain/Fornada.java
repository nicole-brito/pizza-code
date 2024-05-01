package com.soulcode.pizzacode2.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fornadas")
public class Fornada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFornada;

    @Column(nullable = false)
    private Integer numFornada;

    @Column(nullable = false)
    private Integer qtdPizzas;

    @OneToMany(mappedBy = "fornadas")
    private Set<Pedido> IdFornadaPedidoes;
}
