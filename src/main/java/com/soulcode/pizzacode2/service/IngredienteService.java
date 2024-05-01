package com.soulcode.pizzacode2.service;

import com.soulcode.pizzacode2.domain.Ingrediente;
import com.soulcode.pizzacode2.repository.IngredienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IngredienteService {


    @Autowired
    private final IngredienteRepository ingredienteRepository;

    public List<Ingrediente> findAll() {
        return ingredienteRepository.findAll();
    }

    public Ingrediente createIngrediente(Ingrediente ingrediente) {
        if (ingredienteRepository.existsByNome(ingrediente.getNome())) {
            throw new RuntimeException("Já existe um ingrediente com esse nome");
        }
        return ingredienteRepository.save(ingrediente);
    }

    public Ingrediente updateIngrediente(Ingrediente ingrediente) {
        if (!this.ingredienteRepository.existsById(ingrediente.getIdIngrediente())) {
            throw new RuntimeException("Ingrediente não encontrado com o id: " + ingrediente.getIdIngrediente());
        }
        return ingredienteRepository.save(ingrediente);
    }

    public Ingrediente deleteIngrediente(Long idIngrediente) {
        if (!this.ingredienteRepository.existsById(idIngrediente)) {
            throw new RuntimeException("Ingrediente não encontrado com o id: " + idIngrediente);
        }
        this.ingredienteRepository.deleteById(idIngrediente);
        return null;
    }

    public Ingrediente findByIdIngrediente(Long idIngrediente) {
        return ingredienteRepository.findByIdIngrediente(idIngrediente)
                .orElseThrow(() -> new RuntimeException("Ingrediente com o id : " + idIngrediente + " não existe." ));
    }
}
