package com.soulcode.pizzacode2.repository;

import com.soulcode.pizzacode2.domain.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    
    boolean existsByNome(String nome);

    Optional<Pizza> findByIdPizza(Long idPizza);

}
