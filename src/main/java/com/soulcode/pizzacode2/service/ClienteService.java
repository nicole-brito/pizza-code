package com.soulcode.pizzacode2.service;

import com.soulcode.pizzacode2.domain.Bebida;
import com.soulcode.pizzacode2.repository.BebidaRepository;
import com.soulcode.pizzacode2.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public BebidaService(BebidaRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Bebida> findAll() {
        return clienteRepository.findAll();
    }

    public Bebida createBebida(Bebida bebida) {
        if (clienteRepository.existsByNome(bebida.getNome())) {
            throw new RuntimeException("Essa bebida já está cadastrada");
        } else if (bebida.getPreco() < 0) {
            throw new RuntimeException("O preço deve ser positivo e no formato 0.00");
        }
        return clienteRepository.save(bebida);
    }

    public Bebida updateBebida(Bebida bebida) {
        this.clienteRepository.findById(bebida.getIdBebida());
        bebida.setNome(bebida.getNome());
        bebida.setPreco(bebida.getPreco());
        return clienteRepository.save(bebida);
    }

    public Bebida deleteById(Long id) {
        this.clienteRepository.findById(id);
        this.clienteRepository.deleteById(id);
        Bebida bebida = new Bebida();
        bebida.setIdBebida(id);
        return bebida;
    }
}
