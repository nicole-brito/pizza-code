package com.soulcode.pizzacode2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BebidaPedidaTest {

    @Mock
    private Bebida bebida;

    @Mock
    private Pedido pedido;

    private BebidaPedida bebidaPedida;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        bebidaPedida = new BebidaPedida();
        bebidaPedida.setIdBebidaPedida(1L);
        bebidaPedida.setQuantidade(2);
        bebidaPedida.setBebidas(bebida);
        bebidaPedida.setPedidos(pedido);
    }

    @Test
    public void shouldReturnCorrectId() {
        assertEquals(1L, bebidaPedida.getIdBebidaPedida());
    }

    @Test
    public void shouldReturnCorrectQuantity() {
        assertEquals(2, bebidaPedida.getQuantidade());
    }

    @Test
    public void shouldReturnCorrectBebida() {
        assertEquals(bebida, bebidaPedida.getBebidas());
    }

    @Test
    public void shouldReturnCorrectPedido() {
        assertEquals(pedido, bebidaPedida.getPedidos());
    }
}