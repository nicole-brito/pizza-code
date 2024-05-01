package com.soulcode.pizzacode2;

import com.soulcode.pizzacode2.domain.Cliente;
import com.soulcode.pizzacode2.service.ClienteService;
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
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    private Cliente cliente;

    @BeforeEach
    public void setup() {
        cliente = new Cliente();
        cliente.setIdCliente(1L);
        cliente.setNome("Nicole");
        cliente.setTelefone("123456789");
        cliente.setEndereco("Rua A, 123");
        cliente.setLogin("nicole");
        cliente.setSenha("senha123");
    }

    @Test
    public void testCreateCliente() throws Exception {
        when(clienteService.createCliente(any(Cliente.class))).thenReturn(cliente);

        mockMvc.perform(post("/api/clientes/addcliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\":\"Nicole\",\"telefone\":\"123456789\",\"endereco\":\"Rua A, 123\",\"login\":\"nicole\",\"senha\":\"senha123\"}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testFindAll() throws Exception {
        when(clienteService.findAll()).thenReturn(Arrays.asList(cliente));

        mockMvc.perform(get("/api/clientes/"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateCliente() throws Exception {
        when(clienteService.updateCliente(any(Cliente.class))).thenReturn(cliente);

        mockMvc.perform(put("/api/clientes/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\":\"Nicole\",\"telefone\":\"123456789\",\"endereco\":\"Rua A, 123\",\"login\":\"nicole\",\"senha\":\"senha123\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteById() throws Exception {
        when(clienteService.deleteCliente(any(Long.class))).thenReturn(cliente);

        mockMvc.perform(delete("/api/clientes/1"))
                .andExpect(status().isOk());
    }
}