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
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCliente;

    @Column(nullable = false)
    String nome;

    @Column(nullable = false)
    String telefone;

    @Column(nullable = false)
    String endereco;

    @Column(nullable = false)
    String login;

    @Column(nullable = false)
    String senha;

    @OneToMany(mappedBy = "clientes")
    private Set<Pedido> IdClientePedidoes;
}
