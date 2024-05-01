package com.soulcode.pizzacode2.service;

import com.soulcode.pizzacode2.domain.Bebida;
import com.soulcode.pizzacode2.repository.BebidaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BebidaService {

    @Autowired
    private final BebidaRepository bebidaRepository;

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
        this.bebidaRepository.findByIdBebida(bebida.getIdBebida());
        return bebidaRepository.save(bebida);
    }

    public Bebida deleteById(Long id) {
        this.bebidaRepository.findByIdBebida(id);
        this.bebidaRepository.deleteById(id);
        Bebida bebida = new Bebida();
        bebida.setIdBebida(id);
        return bebida;
    }

    public Bebida findBebidaById(Long idBebida) {
        return bebidaRepository.findByIdBebida(idBebida)
                .orElseThrow(() -> new RuntimeException("Bebida com o id " + idBebida + " não existe."));
    }

}