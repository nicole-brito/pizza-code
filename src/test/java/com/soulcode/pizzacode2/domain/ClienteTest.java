package com.soulcode.pizzacode2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {

    @Mock
    private Pedido pedido;

    private Cliente cliente;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        cliente = new Cliente();
        cliente.setIdCliente(1L);
        cliente.setNome("Nicole");
        cliente.setTelefone("123456789");
        cliente.setEndereco("Rua A, 123");
        cliente.setLogin("nicole");
        cliente.setSenha("senha123");
        cliente.setIdClientePedidoes(new HashSet<>() {{
            add(pedido);
        }});
    }

    @Test
    public void shouldReturnCorrectId() {
        assertEquals(1L, cliente.getIdCliente());
    }

    @Test
    public void shouldReturnCorrectName() {
        assertEquals("Nicole", cliente.getNome());
    }

    @Test
    public void shouldReturnCorrectPhone() {
        assertEquals("123456789", cliente.getTelefone());
    }

    @Test
    public void shouldReturnCorrectAddress() {
        assertEquals("Rua A, 123", cliente.getEndereco());
    }

    @Test
    public void shouldReturnCorrectLogin() {
        assertEquals("nicole", cliente.getLogin());
    }

    @Test
    public void shouldReturnCorrectPassword() {
        assertEquals("senha123", cliente.getSenha());
    }

    @Test
    public void shouldReturnCorrectPedido() {
        assertEquals(1, cliente.getIdClientePedidoes().size());
        assertEquals(pedido, cliente.getIdClientePedidoes().iterator().next());
    }
}