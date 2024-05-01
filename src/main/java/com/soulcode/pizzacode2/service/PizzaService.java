package com.soulcode.pizzacode2.service;

import com.soulcode.pizzacode2.domain.Pizza;
import com.soulcode.pizzacode2.repository.PizzaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PizzaService {


    @Autowired
    private final PizzaRepository pizzaRepository;

    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }

    public Pizza createPizza(Pizza pizza) {
        if (pizzaRepository.existsByNome(pizza.getNome())) {
            throw new RuntimeException("Já existe um pizza com esse nome");
        }
        return pizzaRepository.save(pizza);
    }

    public Pizza updatePizza(Pizza pizza) {
        if (!this.pizzaRepository.existsById(pizza.getIdPizza())) {
            throw new RuntimeException("Pizza não encontrada com o id: " + pizza.getIdPizza());
        }
        return pizzaRepository.save(pizza);
    }

    public Pizza deletePizza(Long idPizza) {
        if (!this.pizzaRepository.existsById(idPizza)) {
            throw new RuntimeException("Pizza não encontrada com o id: " + idPizza);
        }
        this.pizzaRepository.deleteById(idPizza);
        return null;
    }

    public Pizza findByIdPizza(Long idPizza) {
        return pizzaRepository.findByIdPizza(idPizza)
                .orElseThrow(() -> new RuntimeException("Pizza com o id : " + idPizza + " não existe." ));
    }
}
