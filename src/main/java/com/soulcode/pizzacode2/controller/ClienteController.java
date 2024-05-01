package com.soulcode.pizzacode2.controller;

import com.soulcode.pizzacode2.domain.Cliente;
import com.soulcode.pizzacode2.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@Slf4j
@RequiredArgsConstructor
public class ClienteController {

    @Autowired
    private final ClienteService clienteService;

    @GetMapping("/")
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> clientes = clienteService.findAll();
        if (clientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<?> getClienteById(@PathVariable Long idCliente) {
        try {
            Cliente cliente = clienteService.findClienteById(idCliente);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (RuntimeException e) {
            log.error("Erro ao criar o cliente", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/addcliente")
    public ResponseEntity<?> createBebida(@RequestBody Cliente cliente) {
        try {
            Cliente createBebida = clienteService.createCliente(cliente);
            return new ResponseEntity<>(createBebida, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            log.error("Erro ao criar novo cliente");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("{idCliente}")
    public ResponseEntity<?> upddateCliente(@RequestBody Cliente cliente) {
        try {
            Cliente updatedCliente = clienteService.updateCliente(cliente);
            return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
        } catch (RuntimeException e) {
            log.error("Erro ao editar o cliente ", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @DeleteMapping("/{idCliente}")
    public ResponseEntity<?> deleteById(@PathVariable Long idCliente) {
        try {
            Cliente deletedCliente = clienteService.deleteCliente(idCliente);
            return new ResponseEntity<>(deletedCliente, HttpStatus.OK);
        } catch (RuntimeException e) {
            log.error("Erro ao deletar o cliente");
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
