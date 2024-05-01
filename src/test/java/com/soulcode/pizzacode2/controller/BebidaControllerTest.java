package com.soulcode.pizzacode2.controller;

import com.soulcode.pizzacode2.domain.Bebida;
import com.soulcode.pizzacode2.service.BebidaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BebidaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BebidaService bebidaService;

    private Bebida bebida;

    @BeforeEach
    public void setup() {
        bebida = new Bebida();
        bebida.setIdBebida(1L);
        bebida.setNome("Coca-Cola");
        bebida.setPreco(3.50);
    }

    @Test
    public void testCreateBebida() throws Exception {
        when(bebidaService.createBebida(any(Bebida.class))).thenReturn(bebida);

        mockMvc.perform(post("/api/bebidas/addbebida")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\":\"Coca-Cola\",\"preco\":3.50}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testFindAll() throws Exception {
        when(bebidaService.findAll()).thenReturn(Arrays.asList(bebida));

        mockMvc.perform(get("/api/bebidas/listadebebidas"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateBebida() throws Exception {
        when(bebidaService.updateBebida(any(Bebida.class))).thenReturn(bebida);

        mockMvc.perform(put("/api/bebidas/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\":\"Coca-Cola\",\"preco\":3.50}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteById() throws Exception {
        when(bebidaService.deleteById(any(Long.class))).thenReturn(bebida);

        mockMvc.perform(delete("/api/bebidas/1"))
                .andExpect(status().isOk());
    }
}