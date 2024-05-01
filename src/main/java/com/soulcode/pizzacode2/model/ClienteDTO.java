package com.soulcode.pizzacode2.model;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
    private Long idCliente;
    private String nome;
    private String telefone;
    private String endereco;
    private String login;
    private String senha;

}
