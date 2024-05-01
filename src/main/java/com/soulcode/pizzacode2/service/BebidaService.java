package com.soulcode.pizzacode2.service;

import com.soulcode.pizzacode2.domain.Bebida;
import com.soulcode.pizzacode2.repository.BebidaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class BebidaService {

    private final BebidaRepository bebidaRepository;

    public BebidaService(BebidaRepository bebidaRepository) {
        this.bebidaRepository = bebidaRepository;
    }

    public List<Bebida> findAll() {
        return bebidaRepository.findAll();
    }

    public Bebida createBebida(Bebida bebida) {
        if (bebidaRepository.existsByNome(bebida.getNome())) {
            throw new RuntimeException("Essa bebida já está cadastrada");
        } else if (bebida.getPreco() < 0) {
            throw new RuntimeException("O preço deve ser positivo e no formato 0.00");
        }
        return bebidaRepository.save(bebida);
    }

    public Bebida updateBebida(Bebida bebida) {
        this.bebidaRepository.findById(bebida.getIdBebida());
        bebida.setNome(bebida.getNome());
        bebida.setPreco(bebida.getPreco());
        return bebidaRepository.save(bebida);
    }

    public Bebida deleteById(Long id) {
        this.bebidaRepository.findById(id);
        this.bebidaRepository.deleteById(id);
        Bebida bebida = new Bebida();
        bebida.setIdBebida(id);
        return bebida;
    }

}