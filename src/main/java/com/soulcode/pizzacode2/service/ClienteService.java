package com.soulcode.pizzacode2.service;

import com.soulcode.pizzacode2.domain.Cliente;
import com.soulcode.pizzacode2.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente createCliente(Cliente cliente) {
        if (clienteRepository.existsByLogin(cliente.getLogin())) {
            throw new RuntimeException("Já existe um usuário com esse login");
        }
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Cliente cliente) {
        if (!this.clienteRepository.existsById(cliente.getIdCliente())) {
            throw new RuntimeException("Cliente não encontrado com o id: " + cliente.getIdCliente());
        }
        return clienteRepository.save(cliente);
    }

    public Cliente deleteCliente(Long idCliente) {
        if (!this.clienteRepository.existsById(idCliente)) {
            throw new RuntimeException("Cliente não encontrado com o id: " + idCliente);
        }
        this.clienteRepository.deleteById(idCliente);
        return null;
    }

    public Cliente findClienteById(Long idCliente) {
        return clienteRepository.findByIdCliente(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente com o id " + idCliente + " não existe."));
    }
}
